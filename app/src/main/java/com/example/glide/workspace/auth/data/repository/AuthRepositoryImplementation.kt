package com.example.glide.workspace.auth.data.repository

import com.example.glide.workspace.auth.data.mappers.toSignUpRequestDTO
import com.example.glide.workspace.auth.data.mappers.toSignUpResult
import com.example.glide.workspace.auth.data.mappers.toVerifyOtpDTO
import com.example.glide.workspace.auth.data.mappers.toVerifyOtpResult
import com.example.glide.workspace.auth.data.remote.api.AuthApi
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User
import com.example.glide.workspace.auth.domain.models.VerifyOtp
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

    override suspend fun signUp(user: User): SignUpResult {
        return try {
            // Convert Domain User → DTO
            val requestDTO = user.toSignUpRequestDTO()

            // Call the API
            val response = api.signUp(requestDTO)

            // Network-level check (HTTP 2xx)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    // API-level check (success field in JSON)
                    if (body.success) {
                        // Success → map DTO to Domain || Mapper
                        body.toSignUpResult()
                    } else {
                        // API returned success = false
                        SignUpResult(false, body.message)
                    }
                } else {
                    // Body is null, unexpected
                    SignUpResult(false, "Empty response from server")
                }
            } else {
                // Network failure (HTTP 4xx/5xx)
                // SignUpResult(false, "Network error: ${response.code()} ${response.message()}")
                SignUpResult(false, "Network error")
            }
        } catch (e: Exception) {
            // Exception (timeout, serialization, etc.)
            // SignUpResult(false, "Unexpected error: ${e.localizedMessage ?: e.message}")
            SignUpResult(false, "Unexpected error")
        }
    }

    override suspend fun verifyOtp(otpData: VerifyOtp): VerifyOtpResult {
        return try {
            // Convert request to dto using mapper i.e Domain layer (use case )-> data layer(api pipeline) as otpData is getting received from domain layer
            val requestDto = otpData.toVerifyOtpDTO()

            // Call the api
            val response = api.verifyOtp(requestDto)
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    if (body.success) {
                        body.toVerifyOtpResult()
                    } else {
                        VerifyOtpResult(success = false, message = body.message)
                    }
                } else {
                    VerifyOtpResult(success = false, message = "Empty response from server")
                }
            } else {
                VerifyOtpResult(success = false, message = "Unexpected error")
            }

        } catch (e: Exception) {
            VerifyOtpResult(success = false, message = "Unexpected error")
        }
    }

}
