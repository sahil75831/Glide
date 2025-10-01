package com.example.glide.workspace.auth.data.remote.dto

data class VerifyOtpResponse(
    val success: Boolean,
    val message: String,
    val token: String
)
