package com.example.glide.workspace.auth.data.remote.api

import com.example.glide.workspace.auth.data.remote.dto.AuthRequest
import com.example.glide.workspace.auth.data.remote.dto.AuthResponse
import com.example.glide.workspace.core.utils.ApiEndpoints
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(ApiEndpoints.REGISTER_USER)
    suspend fun signup(@Body() authRequest: AuthRequest): AuthResponse
}