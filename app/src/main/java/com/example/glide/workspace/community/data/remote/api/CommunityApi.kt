package com.example.glide.workspace.community.data.remote.api

import com.example.glide.workspace.community.data.remote.dto.CreateCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.dto.CreateCommunityResponseDTO
import com.example.glide.workspace.community.data.remote.dto.FetchUserCommunityResponseDTO
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
}