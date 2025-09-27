package com.example.glide.auth.domain.usecase

import com.example.glide.auth.domain.model.OtpVerificationResult
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        sessionId: String,
        otp: String,
        phoneNumber: String
    ): OtpVerificationResult {
        if (otp.isBlank()) {
            return OtpVerificationResult.Error("OTP is required")
        }
        // Additional validation if needed
        return authRepository.verifyOtp(sessionId, otp, phoneNumber)
    }
}