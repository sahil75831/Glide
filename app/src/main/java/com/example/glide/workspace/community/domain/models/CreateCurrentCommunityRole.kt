package com.example.glide.workspace.community.domain.models

data class CreateCurrentCommunityRole (
    val name: String,
    val description: String,
    val permissionKeys: List<String>
)
