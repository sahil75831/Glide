package com.example.glide.workspace.auth.data.remote.dto

data class VerifyOtpRequest(
    val userPhone: String,
    val otp: String,
    val sessionId: String
)
