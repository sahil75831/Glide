package com.example.glide.workspace.community.network.interceptors

import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = authLocalDataSource.getToken()
        val requestBuilder = chain.request().newBuilder()

        if (!token.isNullOrBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}
