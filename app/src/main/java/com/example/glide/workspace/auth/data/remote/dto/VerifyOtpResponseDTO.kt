package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VerifyOtpResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("token") val token: String? = null // <-- Backend is not sending we can implement it later if required
)
