package com.example.glide.workspace.auth.domain.repository

import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User

interface AuthRepository {
    suspend fun signUp(user: User): SignUpResult
}