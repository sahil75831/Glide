package com.example.glide.workspace.community.domain.repository

import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRole
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.domain.models.FetchAllPermissionsResult
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUser
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUserResult


interface CommunityRepository {
    suspend fun createCommunity(createCommunity: CreateCommunity): CreateCommunityResult

    suspend fun fetchUserCommunity(): FetchUserCommunityResult

    suspend fun joinCommunity(joinCommunity: JoinCommunityNewUser): JoinCommunityNewUserResult

    suspend fun createCurrentCommunityRole(createCurrentCommunityRole: CreateCurrentCommunityRole): CreateCurrentCommunityRoleResult

    suspend fun fetchAllPermissions(): FetchAllPermissionsResult
}