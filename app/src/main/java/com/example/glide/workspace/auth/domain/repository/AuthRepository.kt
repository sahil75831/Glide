package com.example.glide.workspace.auth.domain.repository

import com.example.glide.workspace.auth.domain.models.CommunityCreationResult
import com.example.glide.workspace.auth.domain.models.OtpVerificationResult

interface AuthRepository {
    suspend fun createCommunity(
        userName: String,
        userPhone: String,
        userEmail: String,
        communityName: String
    ): CommunityCreationResult

    suspend fun verifyOtp(
        userPhone: String,
        otp:String,
        sessionId: String
    ): OtpVerificationResult
}