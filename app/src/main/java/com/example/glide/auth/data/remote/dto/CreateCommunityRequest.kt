package com.example.glide.auth.data.remote.dto

data class CreateCommunityRequest(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val communityName: String
)
