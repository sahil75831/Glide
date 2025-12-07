package com.example.glide.workspace.community.domain.models

data class FetchAllPermissionsResult(
    val success: Boolean,
    val message: String,
    val permissions: List<PermissionResult?> = emptyList()
)
data class PermissionResult(
    val id: String,
    val key: String,
    val description: String
)