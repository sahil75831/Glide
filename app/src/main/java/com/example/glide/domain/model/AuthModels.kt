package com.example.glide.domain.model

data class User(
    val email:String,
    val password:String
)

data class AuthResponse(
    val accessToken:String,
    val refreshToken: String,
    val user: User
)
