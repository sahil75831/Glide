package com.example.glide.auth.data.remote.dto

data class VerifyOtpRequest(
    val sessionId: String,
    val otp: String,
    val phoneNumber: String
)
