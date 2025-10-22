package com.example.glide.workspace.auth.domain.models

import com.example.glide.workspace.auth.data.remote.dto.User

sealed class SignUpResult {
    data class Success(
        val success: Boolean,
        val message: String,
        val user: User,
        val sessionId: String
        ): SignUpResult()

    data class Error(
        val success: Boolean,
        val message: String
    ): SignUpResult()
}