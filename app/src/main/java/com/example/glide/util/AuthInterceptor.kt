package com.example.glide.util

import com.example.glide.data.api.AuthApi
import com.example.glide.data.local.SecureStorage
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val secureStorage: SecureStorage,
    private val authApiProvider: Provider<AuthApi> // Use Provider for lazy injection
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = secureStorage.getAccessToken()
        val authorizedRequest = if (token != null) {
            originalRequest.newBuilder().header("Authorization", "Bearer $token").build()
        } else originalRequest

        val response = chain.proceed(authorizedRequest)
        if (response.code == 401) {
            val refreshToken = secureStorage.getRefreshToken() ?: return response
            return runBlocking {
                try {
                    val authApi = authApiProvider.get() // Get AuthApi lazily
                    val refreshResponse = authApi.refreshToken(mapOf("refreshToken" to refreshToken))
                    secureStorage.saveAccessToken(refreshResponse.accessToken)
                    secureStorage.saveRefreshToken(refreshResponse.refreshToken)
                    val retryRequest = originalRequest.newBuilder()
                        .header("Authorization", "Bearer ${refreshResponse.accessToken}")
                        .build()
                    chain.proceed(retryRequest)
                } catch (e: Exception) {
                    secureStorage.clearTokens()
                    response
                }
            }
        }
        return response
    }
}