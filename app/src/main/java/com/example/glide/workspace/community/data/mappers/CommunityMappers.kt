package com.example.glide.workspace.community.data.mappers

import com.example.glide.workspace.community.data.remote.dto.CommunityDTO
import com.example.glide.workspace.community.data.remote.dto.CommunityMembershipDTO
import com.example.glide.workspace.community.data.remote.dto.CommunityToJoin
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCurrentCommunityRoleDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCurrentCommunityRoleResponseDTO
import com.example.glide.workspace.community.data.remote.dto.FetchAllPermissionsDTO
import com.example.glide.workspace.community.data.remote.dto.FetchUserCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.JoinCommunityNewUserRequestDTO
import com.example.glide.workspace.community.data.remote.dto.JoinCommunityNewUserResponseDTO
import com.example.glide.workspace.community.data.remote.dto.PermissionsDTO
import com.example.glide.workspace.community.data.remote.dto.RoleDTO
import com.example.glide.workspace.community.domain.models.Community
import com.example.glide.workspace.community.domain.models.CommunityMembership
import com.example.glide.workspace.community.domain.models.CommunityToJoinResult
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRole
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.domain.models.FetchAllPermissionsResult
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUser
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUserResult
import com.example.glide.workspace.community.domain.models.PermissionResult
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

// DOMAIN TO DATA
fun JoinCommunityNewUser.toJoinCommunityRequestDTO(): JoinCommunityNewUserRequestDTO {
    return JoinCommunityNewUserRequestDTO(
        inviteecode = inviteecode
    )
}



// DATA TO DOMAIN LAYER
fun JoinCommunityNewUserResponseDTO.toJoinCommunityNewUserResult(): JoinCommunityNewUserResult {
    return JoinCommunityNewUserResult(
        success = success,
        message = message,
        communityToJoin = communityToJoin?.toCommunityToJoinResult(),
        assignedRolesOfNewCommunity = assignedRolesOfNewCommunity
    )
}

// Add this helper extension function to convert Community DTO to CommunityResult domain model
fun CommunityToJoin.toCommunityToJoinResult(): CommunityToJoinResult {
    return CommunityToJoinResult(
        id = id,
        name = name
    )
}

// DOMAIN TO DATA LAYER
fun CreateCurrentCommunityRole.toCreateCurrentCommunityRoleDTO(): CreateCurrentCommunityRoleDTO {
    return CreateCurrentCommunityRoleDTO(
        name = name,
        description = description,
        permissionKeys = permissionKeys
    )
}

fun CreateCurrentCommunityRoleResponseDTO.toCreateCurrentCommunityRoleResult(): CreateCurrentCommunityRoleResult {
    return CreateCurrentCommunityRoleResult(
        success = success,
        message = message
    )
}

// DOMAIN TO DATA
fun FetchAllPermissionsDTO.toFetchAllPermissions(): FetchAllPermissionsResult {
    return FetchAllPermissionsResult(
        success = success,
        message = message,
        permissions = permissions
            .filterNotNull()               // remove nulls safely
            .map { it.toPermissionResult() }
    )
}
fun PermissionsDTO.toPermissionResult(): PermissionResult {
    return PermissionResult(
        id = id,
        key = key,
        description = description
    )
}