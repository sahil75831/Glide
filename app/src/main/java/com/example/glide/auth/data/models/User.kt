package com.example.glide.auth.data.models

data class User(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val communityName: String? = null,
    val roleId: String? = null,
    val accessId: String? = null
)
