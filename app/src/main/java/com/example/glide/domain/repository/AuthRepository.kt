package com.example.glide.domain.repository

import com.example.glide.domain.model.AuthResponse
import com.example.glide.util.AuthResult

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResult<AuthResponse>
    suspend fun logout(): AuthResult<Unit>
    suspend fun forgotPassword(email: String): AuthResult<Unit>
    fun getAccessToken(): String?
    fun isLoggedIn(): Boolean
}