package com.example.glide.workspace.auth.domain.models

data class VerifyOtp(
    val phone: String,
    val phoneOtp: String,
    val email: String,
    val emailOtp: String
)
