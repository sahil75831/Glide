package com.example.glide.workspace.community.domain.models


data class CreateCommunity(
    val name: String,
    val address: String,
    val city: String,
    val state: String,
    val pincode: String,
    val country: String,
    val description: String,
    val type: String,
)
