package com.example.glide.workspace.community.domain.repository

import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult

interface CommunityRepository {
    suspend fun createCommunity(createCommunity: CreateCommunity): CreateCommunityResult
}