package com.example.glide.workspace.community.domain.usecases

import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRole
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class CreateCurrentCommunityRoleUseCase @Inject constructor(
    private val communityRepository: CommunityRepository
) {
    suspend operator fun invoke(createCurrentCommunityRole: CreateCurrentCommunityRole): CreateCurrentCommunityRoleResult {
        // DeStructure the properties
        val (name, description, permissionKeys) = createCurrentCommunityRole

        if(name.isBlank()){
            return CreateCurrentCommunityRoleResult(false, "Role name can not be blank")
        }
        if(description.isBlank()){
            return CreateCurrentCommunityRoleResult(false, "Role description cant not be blank")
        }
        if(name.isEmpty()){
            return CreateCurrentCommunityRoleResult(false, "At least one permission key is required")
        }
        return try {
            communityRepository.createCurrentCommunityRole(createCurrentCommunityRole)
        }catch (e: Exception){
            CreateCurrentCommunityRoleResult(success = false, message = "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }
}