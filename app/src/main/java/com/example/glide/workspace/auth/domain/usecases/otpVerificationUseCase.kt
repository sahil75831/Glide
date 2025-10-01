package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.domain.models.CommunityCreationResult
import com.example.glide.workspace.auth.domain.models.OtpVerificationResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(userPhone:String,  otp:String, sessionId:String): OtpVerificationResult{
        if(userPhone.isBlank() || sessionId.isBlank() || otp.isBlank()) {
            return OtpVerificationResult.Error("All fields are mandatory")
        }
        return authRepository.verifyOtp(userPhone, otp, sessionId)
    }
}