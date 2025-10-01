package com.example.glide.workspace.auth.data.remote.api

import com.example.glide.workspace.auth.data.remote.dto.CreateCommunityRequest
import com.example.glide.workspace.auth.data.remote.dto.CreateCommunityResponse
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpRequest
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpResponse
import com.example.glide.workspace.core.utils.ApiEndpoints
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(ApiEndpoints.CREATE_COMMUNITY)
    suspend fun createCommunity(@Body createCommunityRequest: CreateCommunityRequest) : CreateCommunityResponse

    @POST(ApiEndpoints.VERIFY_OTP)
    suspend fun verifyOtp(@Body verifyOtpRequest: VerifyOtpRequest) : VerifyOtpResponse
}