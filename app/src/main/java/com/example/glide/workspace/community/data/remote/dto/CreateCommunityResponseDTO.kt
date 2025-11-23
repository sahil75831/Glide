package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CreateCommunityResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("communityId") val communityId: String?,
)
