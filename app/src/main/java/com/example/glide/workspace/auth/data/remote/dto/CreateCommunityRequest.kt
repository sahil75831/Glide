package com.example.glide.workspace.auth.data.remote.dto

data class CreateCommunityRequest(
    val userName: String,
    val userPhone: String,
    val userEmail: String,
    val communityName: String
)
