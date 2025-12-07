package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CreateCurrentCommunityRoleDTO(
    @SerializedName("name")  val name:String,
    @SerializedName("description") val description: String,
    @SerializedName("permissionKeys") val permissionKeys: List<String>
)
