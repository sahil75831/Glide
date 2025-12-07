package com.example.glide.workspace.community.data.remote.dto

import com.google.gson.annotations.SerializedName

data class JoinCommunityNewUserRequestDTO(
    @SerializedName("inviteecode") val inviteecode:String
)
