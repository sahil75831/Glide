package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("user") val user: User? = null,
    @SerializedName("sessionId") val sessionId: String? = null
)