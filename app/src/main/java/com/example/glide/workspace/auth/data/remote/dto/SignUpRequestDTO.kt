package com.example.glide.workspace.auth.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignUpRequestDTO(
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("governmentId") val governmentId: String,
    @SerializedName("governmentIdType") val governmentIdType: String,
    @SerializedName("age") val age: Int,
    @SerializedName("gender") val gender: String,
    @SerializedName("address") val address: String
)