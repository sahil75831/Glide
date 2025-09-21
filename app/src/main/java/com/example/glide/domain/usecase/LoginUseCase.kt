package com.example.glide.domain.usecase

import com.example.glide.domain.model.AuthResponse
import com.example.glide.domain.repository.AuthRepository
import com.example.glide.util.AuthResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): AuthResult<AuthResponse> {
        if (email.isBlank() || !email.contains("@")) return AuthResult.Error("Invalid email")
        if (password.length < 8) return AuthResult.Error("Password too short")
        return repository.login(email, password)
    }
}