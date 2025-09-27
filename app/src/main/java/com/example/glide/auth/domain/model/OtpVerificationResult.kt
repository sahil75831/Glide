package com.example.glide.auth.domain.model

sealed class OtpVerificationResult {
    data class Success(val token: String): OtpVerificationResult()
    data class Error(val message: String): OtpVerificationResult()

}