package com.example.glide.auth.data.models

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val error: String? = null,
    val data: Map<String, Any>? = null
)
