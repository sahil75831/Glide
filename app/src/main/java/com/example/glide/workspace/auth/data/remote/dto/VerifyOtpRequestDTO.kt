package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VerifyOtpRequestDTO(
    @SerializedName("phone") val phone : String,
    @SerializedName("phoneOtp") val phoneOtp: String,
    @SerializedName("email") val email : String,
    @SerializedName("emailOtp") val emailOtp: String,
)
