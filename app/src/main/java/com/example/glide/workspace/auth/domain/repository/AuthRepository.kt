package com.example.glide.workspace.auth.domain.repository

import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User
import com.example.glide.workspace.auth.domain.models.VerifyOtp
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult

interface AuthRepository {
    suspend fun signUp(user: User): SignUpResult

    suspend fun verifyOtp(otpData: VerifyOtp): VerifyOtpResult
}