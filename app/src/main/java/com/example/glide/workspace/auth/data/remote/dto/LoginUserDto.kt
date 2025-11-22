package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginUserDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
