package com.example.glide.auth.data.remote.dto

data class VerifyOtpResponse(
    val success: Boolean,
    val message: String?,
    val token: String?
)
