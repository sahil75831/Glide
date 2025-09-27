package com.example.glide.auth.data.remote.api

import com.example.glide.auth.data.remote.dto.CreateCommunityRequest
import com.example.glide.auth.data.remote.dto.CreateCommunityResponse
import com.example.glide.auth.data.remote.dto.VerifyOtpRequest
import com.example.glide.auth.data.remote.dto.VerifyOtpResponse
import com.example.glide.auth.utils.ApiEndpoints
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(ApiEndpoints.CREATE_COMMUNITY)
    suspend fun createCommunity(@Body request:CreateCommunityRequest): CreateCommunityResponse

    @POST(ApiEndpoints.VERIFY_OTP)
    suspend fun verifyOtp(@Body request: VerifyOtpRequest): VerifyOtpResponse
}