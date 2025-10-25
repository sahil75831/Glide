package com.example.glide.workspace.auth.domain.models

data class User(
    val name: String,
    val phone: String,
    val email: String,
    val password: String,
    val governmentId: String,
    val governmentIdType: String,
    val age: Int,
    val gender: String,
    val address: String
)
