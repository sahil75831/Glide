package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FetchAllPermissionsDTO(
    @SerializedName("success") val success: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("permissions") val permissions: List<PermissionsDTO?> = emptyList()
)

data class PermissionsDTO(
    @SerializedName("id") val id: String,
    @SerializedName("key") val key: String,
    @SerializedName("description") val description: String,
)
