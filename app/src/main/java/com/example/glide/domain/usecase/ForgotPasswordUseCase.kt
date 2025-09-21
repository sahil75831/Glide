package com.example.glide.domain.usecase

import com.example.glide.domain.repository.AuthRepository
import com.example.glide.util.AuthResult
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String): AuthResult<Unit> {
        if (email.isBlank() || !email.contains("@")) return AuthResult.Error("Invalid email")
        return repository.forgotPassword(email)
    }
}