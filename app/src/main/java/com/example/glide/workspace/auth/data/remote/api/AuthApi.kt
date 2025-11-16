package com.example.glide.workspace.auth.data.remote.api

import com.example.glide.workspace.auth.data.remote.dto.SignUpRequestDTO
import com.example.glide.workspace.auth.data.remote.dto.SignUpResponseDTO
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpRequestDTO
import com.example.glide.workspace.auth.data.remote.dto.VerifyOtpResponseDTO
import com.example.glide.workspace.core.ApiEndpoints
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST(ApiEndpoints.SIGN_UP_USER)
    suspend fun signUp(@Body() signUpRequest: SignUpRequestDTO): Response<SignUpResponseDTO>

    @POST(ApiEndpoints.VERIFY_OTP)
    suspend fun verifyOtp(@Body() verifyOtpRequest: VerifyOtpRequestDTO): Response<VerifyOtpResponseDTO>
}