package com.example.glide.domain.usecase

import com.example.glide.domain.repository.AuthRepository
import com.example.glide.util.AuthResult

import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(): AuthResult<Unit> = repository.logout()
}