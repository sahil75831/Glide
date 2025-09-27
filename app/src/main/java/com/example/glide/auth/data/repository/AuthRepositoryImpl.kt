package com.example.glide.auth.data.repository

import com.example.glide.auth.data.remote.api.AuthApi
import com.example.glide.auth.data.remote.dto.CreateCommunityRequest
import com.example.glide.auth.data.remote.dto.CreateCommunityResponse
import com.example.glide.auth.data.remote.dto.VerifyOtpRequest
import com.example.glide.auth.domain.model.CommunityCreationResult
import com.example.glide.auth.domain.model.OtpVerificationResult
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun createCommunity(
        name: String,
        email: String,
        phoneNumber: String,
        communityName: String
    ): CommunityCreationResult {
        return try {
            val request: CreateCommunityRequest = CreateCommunityRequest(name, email, phoneNumber, communityName)
            val response: CreateCommunityResponse = authApi.createCommunity(request)
            if (response.success) {
                CommunityCreationResult.Success(response.sessionId ?: "")
            } else {
                CommunityCreationResult.Error(response.message ?: "Unknown error")
            }
        } catch (e: Exception) {
            CommunityCreationResult.Error(e.message ?: "Network error")
        }
    }

    override suspend fun verifyOtp(
        sessionId: String,
        phoneNumber: String,
        otp: String
    ): OtpVerificationResult {
        return try {
            val request = VerifyOtpRequest(sessionId, otp, phoneNumber)
            val response = authApi.verifyOtp(request)
            if (response.success) {
                OtpVerificationResult.Success(response.token ?: "")
            } else {
                OtpVerificationResult.Error(response.message ?: "Unknown error")
            }
        } catch (e: Exception) {
            OtpVerificationResult.Error(e.message ?: "Network error")
        }
    }
}