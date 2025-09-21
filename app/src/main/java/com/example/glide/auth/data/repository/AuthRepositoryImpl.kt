package com.example.glide.auth.data.repository

import com.example.glide.auth.data.models.User
import com.example.glide.auth.data.remote.AuthService
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthService
) : AuthRepository {
    override suspend fun createCommunity(user: User): Result<String> {
        return try {
            val response = api.createCommunity(user)
            if (response.success) {
                Result.success(response.message)
            } else {
                Result.failure(Exception(response.error ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun verifyOtp(phone: String, otp: String): Result<String> {
        val body = mapOf("phone" to phone, "otp" to otp)
        return try {
            val response = api.verifyOtp(body)
            if (response.success) {
                Result.success(response.message)
            } else {
                Result.failure(Exception(response.error ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}