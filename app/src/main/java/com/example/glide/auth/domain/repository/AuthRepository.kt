package com.example.glide.auth.domain.repository

import com.example.glide.auth.data.models.User

interface AuthRepository {
    suspend fun createCommunity(user: User): Result<String>
    suspend fun verifyOtp(phone: String, otp: String): Result<String>
}