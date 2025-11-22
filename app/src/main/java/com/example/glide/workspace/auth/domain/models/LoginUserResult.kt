package com.example.glide.workspace.auth.domain.models

data class LoginUserResult(
    val success: Boolean,
    val message: String,
    val authToken: String? = null
)
