package com.example.glide.auth.utils

object EndPoints {
    private const val BASE_URL = "http://10.0.2.2:5000/" // Emulator localhost

    object Auth {
        const val VERIFY_OTP = "api/auth/verify-otp"
    }

    object Community {
        const val CREATE = "api/community/create"
        const val JOIN = "api/community/join"
    }

    fun getBaseUrl(): String = BASE_URL
}