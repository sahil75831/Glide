package com.example.glide.data.api

import com.example.glide.domain.model.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/auth/login")
    suspend fun login(@Body request: Map<String, String>): AuthResponse // Body: {"email": "...", "password": "..."}

    @POST("api/auth/logout")
    suspend fun logout(): Map<String, String> // Returns success message or whatever your backend sends

    @POST("api/auth/forget-password")
    suspend fun forgotPassword(@Body request: Map<String, String>): Map<String, String> // Body {"email": "..."}

    // Optional: If your backend has token refresh, add this. Otherwise, skip it for now.
    @POST("api/auth/refresh")
    suspend fun refreshToken(@Body request: Map<String, String>): AuthResponse // {"refreshToken": "..."}
}
