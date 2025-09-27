package com.example.glide.auth.data.remote.dto

data class CreateCommunityResponse(
    val success: Boolean,
    val message: String,
    val sessionId: String
)
