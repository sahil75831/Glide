package com.example.glide.data.repository

import com.example.glide.data.api.AuthApi
import com.example.glide.data.local.SecureStorage
import com.example.glide.domain.model.AuthResponse
import com.example.glide.domain.repository.AuthRepository
import com.example.glide.util.AuthResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val secureStorage: SecureStorage
):AuthRepository {
    override suspend fun login(email: String, password: String): AuthResult<AuthResponse> {
        return try {
            val response = authApi.login(mapOf("email" to email, "password" to password))
            secureStorage.saveAccessToken(response.accessToken)
            secureStorage.saveRefreshToken(response.refreshToken)
            AuthResult.Success(response)
        }catch (e: Exception){
            AuthResult.Error("Login failed: ${e.message}")
        }
    }

    override suspend fun logout(): AuthResult<Unit> {
        return try {
            authApi.logout()
            secureStorage.clearTokens()
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            secureStorage.clearTokens()
            AuthResult.Error("Logout failed: ${e.message}", e)
        }
    }

    override suspend fun forgotPassword(email: String): AuthResult<Unit> {
        return try {
            authApi.forgotPassword(mapOf("email" to email))
            AuthResult.Success(Unit)
        } catch (e: Exception) {
            AuthResult.Error("Forgot password failed: ${e.message}", e)
        }
    }

    override fun getAccessToken(): String? = secureStorage.getAccessToken()

    override fun isLoggedIn(): Boolean = getAccessToken() != null
}