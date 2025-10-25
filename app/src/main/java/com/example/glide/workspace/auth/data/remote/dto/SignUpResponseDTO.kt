package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignUpResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)
