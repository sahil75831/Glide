package com.example.glide.workspace.community.data.mappers

import com.example.glide.workspace.community.data.remote.dto.CommunityDTO
import com.example.glide.workspace.community.data.remote.dto.CommunityMembershipDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.FetchUserCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.RoleDTO
import com.example.glide.workspace.community.domain.models.Community
import com.example.glide.workspace.community.domain.models.CommunityMembership
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.models.Role

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

// DATA LAYER TO DOMAIN LAYER THAT IS RESPONSE IS GETTING CONVERTED TO DOMAIN LAYER SO THAT USE CASE CAM TAKE IT AS ARGUMENT
fun FetchUserCommunityResponseDTO.toFetchUserCommunityResult(): FetchUserCommunityResult{
    return FetchUserCommunityResult(
        success = success,
        message = message,
        communities =  data.map { it.toCommunityMembership() }
    )
}
// Helper mapper for CommunityMembershipDTO to domain
fun CommunityMembershipDTO.toCommunityMembership():CommunityMembership {
    return CommunityMembership(
        membershipId = membershipId,
        assignedAt = assignedAt,
        role = role.toRole(),
        community = community.toCommunity()
    )
}

// Helper mapper for RoleDTO to domain
fun RoleDTO.toRole(): Role{
    return Role(
        id = id,
        name = name
    )
}
// Helper mapper for CommunityDTO to domain
fun CommunityDTO.toCommunity(): Community{
    return Community(
        id = id,
        name = name,
        address = address,
        city = city,
        state = state,
        country = country,
        pincode = pincode,
        type = type
    )
}

