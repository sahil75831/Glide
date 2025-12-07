package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class JoinCommunityNewUserResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("community") val communityToJoin: CommunityToJoin? = null,
    @SerializedName("assignedRoles") val assignedRolesOfNewCommunity: List<String>? = null
)

data class CommunityToJoin(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)