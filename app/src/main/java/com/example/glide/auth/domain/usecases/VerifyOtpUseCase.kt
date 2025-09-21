package com.example.glide.auth.domain.usecases

import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class VerifyOtpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(phone: String, otp: String): Result<String> {
        if (phone.isBlank()) return Result.failure(Exception("Phone number cannot be blank"))
        if (otp.isBlank() || otp.length != 6) return Result.failure(Exception("OTP must be 6 digits"))
        return authRepository.verifyOtp(phone, otp)
    }
}