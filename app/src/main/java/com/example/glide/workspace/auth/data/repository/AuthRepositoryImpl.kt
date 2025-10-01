package com.example.glide.workspace.auth.data.repository

import com.example.glide.workspace.auth.data.remote.api.AuthApi
import com.example.glide.workspace.auth.data.remote.dto.CreateCommunityRequest
import com.example.glide.workspace.auth.data.remote.dto.CreateCommunityResponse
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpRequest
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpResponse
import com.example.glide.workspace.auth.domain.models.CommunityCreationResult
import com.example.glide.workspace.auth.domain.models.OtpVerificationResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authApi: AuthApi): AuthRepository {
    override suspend fun createCommunity(
        userName: String,
        userPhone: String,
        userEmail: String,
        communityName: String
    ): CommunityCreationResult {
        return try {
            val request: CreateCommunityRequest = CreateCommunityRequest( userName, userPhone, userEmail, communityName )
            val response: CreateCommunityResponse = authApi.createCommunity(request)
            if(response.success) {
                CommunityCreationResult.Success(sessionId = response.sessionId ?: "")
            }else {
                CommunityCreationResult.Error(response.message ?: "Unknown error1")
            }
        }catch (e: Exception){
            CommunityCreationResult.Error(e.message ?: "Network Error")
        }
    }

    override suspend fun verifyOtp(userPhone: String, otp:String, sessionId: String): OtpVerificationResult {
        return try {
            val request: VerifyOtpRequest = VerifyOtpRequest( userPhone, otp, sessionId )
            val response: VerifyOtpResponse = authApi.verifyOtp(request)
            if(response.success) {
                OtpVerificationResult.Success(token = response.token ?: "")
            }else {
                OtpVerificationResult.Error(response.message ?: "Unknown error ")
            }
        }catch (e: Exception){
            OtpVerificationResult.Error(e.message ?: "Network Error")
        }
    }
}