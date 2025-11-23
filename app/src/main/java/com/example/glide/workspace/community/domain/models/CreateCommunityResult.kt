package com.example.glide.workspace.community.domain.models

data class CreateCommunityResult(
    val success: Boolean,
    val message: String,
    val communityId: String? = null
)
