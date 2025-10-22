package com.example.glide.workspace.auth.data.repository

import com.example.glide.workspace.auth.data.remote.api.AuthApi
import com.example.glide.workspace.auth.data.remote.dto.AuthRequest
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun signUp(authRequest: AuthRequest): SignUpResult {
        return try {
            val response = authApi.signup(authRequest)

            if (response.success && response.user != null) {
                SignUpResult.Success(
                    success = true,
                    message = response.message ?: "Sign up successful",
                    user = response.user,
                    sessionId = response.sessionId ?: ""
                )
            } else {
                SignUpResult.Error(
                    success = false,
                    message = response.message ?: "Sign up failed"
                )
            }
        } catch (e: Exception) {
            SignUpResult.Error(
                success = false,
                message = e.localizedMessage ?: "Unexpected error"
            )
        }
    }
}