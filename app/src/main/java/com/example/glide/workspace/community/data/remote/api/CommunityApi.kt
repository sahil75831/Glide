package com.example.glide.workspace.community.data.remote.api

import com.example.glide.workspace.community.data.remote.dto.CreateCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCurrentCommunityRoleDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCurrentCommunityRoleResponseDTO
import com.example.glide.workspace.community.data.remote.dto.FetchAllPermissionsDTO
import com.example.glide.workspace.community.data.remote.dto.FetchUserCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.JoinCommunityNewUserRequestDTO
import com.example.glide.workspace.community.data.remote.dto.JoinCommunityNewUserResponseDTO
import com.example.glide.workspace.core.ApiEndpoints
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CommunityApi {
    @POST(ApiEndpoints.CREATE_COMMUNITY)
    suspend fun createCommunity( @Body() createCommunityRequest: CreateCommunityRequestDTO ): Response<CreateCommunityResponseDTO>

    @GET(ApiEndpoints.FETCH_USER_COMMUNITY)
    suspend fun fetchUserCommunity(): Response<FetchUserCommunityResponseDTO>

    @POST(ApiEndpoints.JOIN_COMMUNITY)
    suspend fun joinCommunity( @Body() joinCommunityNewUserRequestDTO:  JoinCommunityNewUserRequestDTO): Response<JoinCommunityNewUserResponseDTO>

    @POST(ApiEndpoints.CREATE_CURRENT_COMMUNITY_ROLE)
    suspend fun createCurrentCommunityRole(@Body() createCurrentCommunityRoleDTO: CreateCurrentCommunityRoleDTO): Response<CreateCurrentCommunityRoleResponseDTO>

    @GET(ApiEndpoints.FETCH_ALL_PERMISSIONS)
    suspend fun fetchAllPermissions(): Response<FetchAllPermissionsDTO>
}