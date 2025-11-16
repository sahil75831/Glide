package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.VerifyOtp
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository

class VerifyOtpUseCase constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(verifyOtpData: VerifyOtp): VerifyOtpResult {
        // De-structure properties from verify-otp parameter
        val (phone, phoneOtp, email, emailOtp) = verifyOtpData
        if(phone.isBlank()) return VerifyOtpResult(success = false, message = "Phone number cannot be blank")
        if(phoneOtp.isBlank()) return VerifyOtpResult(success = false, message = "Phone Otp cannot be blank")
        if(email.isBlank()) return VerifyOtpResult(success = false, message = "Email id cannot be blank")
        if(emailOtp.isBlank()) return VerifyOtpResult(success = false, message = "Email Otp cannot be blank")

        // 2 Delegate to repository
        return try {
            authRepository.verifyOtp(verifyOtpData)
        } catch (e: Exception) {
            VerifyOtpResult(false, "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }
}