package com.example.glide.workspace.community.data.mappers

import com.example.glide.workspace.community.data.remote.dto.CreateCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityResponseDTO
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult

// DOMAIN TO DATA LAYER : Use case  will pass the data that means domain to data
fun CreateCommunity.toCreateCommunityRequestDTO() : CreateCommunityRequestDTO {
    return CreateCommunityRequestDTO(
        name = name,
        address = address,
        city = city,
        state = state,
        pincode = pincode,
        country = country,
        description = description,
        type = type
    )
}

// DATA TO DOMAIN LAYER
fun CreateCommunityResponseDTO.toCreateCommunityResult(): CreateCommunityResult {
    return CreateCommunityResult(
        success = success,
        message = message,
        communityId = communityId
    )
}