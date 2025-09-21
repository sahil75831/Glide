package com.example.glide.auth.data.remote

import com.example.glide.auth.data.models.ApiResponse
import com.example.glide.auth.data.models.User
import com.example.glide.auth.utils.EndPoints
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST(EndPoints.Community.CREATE)
    suspend fun createCommunity(@Body user: User): ApiResponse

    @POST(EndPoints.Auth.VERIFY_OTP)
    suspend fun verifyOtp(@Body body: Map<String, String>): ApiResponse
}