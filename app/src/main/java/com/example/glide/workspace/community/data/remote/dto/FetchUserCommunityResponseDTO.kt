package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FetchUserCommunityResponseDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<CommunityMembershipDTO> = emptyList()
)

data class CommunityMembershipDTO(
    @SerializedName("ucrId") val membershipId: String,
    @SerializedName("assignedAt") val assignedAt: String,
    @SerializedName("role") val role: RoleDTO,
    @SerializedName("community") val community: CommunityDTO
)

data class RoleDTO(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)

data class CommunityDTO(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("pincode") val pincode: String,
    @SerializedName("type") val type: String
)