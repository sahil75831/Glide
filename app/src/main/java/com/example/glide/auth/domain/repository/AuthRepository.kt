package com.example.glide.auth.domain.repository

import com.example.glide.auth.domain.model.CommunityCreationResult
import com.example.glide.auth.domain.model.OtpVerificationResult

interface AuthRepository {
    suspend fun createCommunity(
        name: String,
        email: String,
        phoneNumber: String,
        communityName: String
    ): CommunityCreationResult

    suspend fun verifyOtp(
        sessionId: String,
        phoneNumber: String,
        otp: String
    ): OtpVerificationResult
}