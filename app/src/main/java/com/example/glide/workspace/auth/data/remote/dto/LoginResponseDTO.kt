package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("authToken") val authToken: String? = null
)