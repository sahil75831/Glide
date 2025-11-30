package com.example.glide.workspace.community.domain.models

data class FetchUserCommunityResult(
    val success: Boolean,
    val message: String,
    val communities: List<CommunityMembership> = emptyList()
)

data class CommunityMembership(
    val membershipId: String,
    val assignedAt: String,
    val role: Role,
    val community: Community
)

data class Role(
    val id: String,
    val name: String
)

data class Community(
    val id: String,
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val country: String,
    val pincode: String,
    val type: String
)