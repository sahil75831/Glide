package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CreateCommunityRequestDTO(
    @SerializedName("name") val name:String,
    @SerializedName("address") val address:String,
    @SerializedName("city") val city:String,
    @SerializedName("state") val state:String,
    @SerializedName("pincode") val pincode:String,
    @SerializedName("country") val country:String,
    @SerializedName("description") val description:String,
    @SerializedName("type") val type:String,
)
