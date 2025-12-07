package com.example.glide.workspace.community.domain.models


data class JoinCommunityNewUserResult(
    val success: Boolean,
    val message: String,
    val communityToJoin: CommunityToJoinResult? = null,
    val assignedRolesOfNewCommunity: List<String>? = null
)

data class CommunityToJoinResult(
    val id: String,
    val name: String
)
