package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CreateCurrentCommunityRoleResponseDTO (
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String
)
