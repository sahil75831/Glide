package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.data.remote.dto.AuthRequest
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(authRequest: AuthRequest): SignUpResult {
        return authRepository.signUp(authRequest)
    }
}