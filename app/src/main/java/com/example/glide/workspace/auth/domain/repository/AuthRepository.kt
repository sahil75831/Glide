package com.example.glide.workspace.auth.domain.repository

import com.example.glide.workspace.auth.data.remote.dto.AuthRequest
import com.example.glide.workspace.auth.domain.models.SignUpResult

interface AuthRepository {
    suspend fun signUp(authRequest: AuthRequest): SignUpResult
}