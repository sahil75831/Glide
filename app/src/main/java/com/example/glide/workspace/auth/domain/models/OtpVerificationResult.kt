package com.example.glide.workspace.auth.domain.models

sealed class OtpVerificationResult {
    data class Success(val token: String): OtpVerificationResult()
    data class Error(val message: String): OtpVerificationResult()
}