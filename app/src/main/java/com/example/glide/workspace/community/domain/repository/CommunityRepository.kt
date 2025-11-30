package com.example.glide.workspace.community.domain.repository

import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult

interface CommunityRepository {
    suspend fun createCommunity(createCommunity: CreateCommunity): CreateCommunityResult

    suspend fun fetchUserCommunity(): FetchUserCommunityResult
}