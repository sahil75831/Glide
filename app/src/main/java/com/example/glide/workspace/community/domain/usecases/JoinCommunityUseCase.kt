package com.example.glide.workspace.community.domain.usecases

import com.example.glide.workspace.community.domain.models.JoinCommunityNewUser
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUserResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class JoinCommunityUseCase @Inject constructor(
    private val communityRepository: CommunityRepository
) {
    suspend operator fun invoke(joinCommunityNewUser: JoinCommunityNewUser): JoinCommunityNewUserResult {
        // De Structure the properties
        val (inviteecode) = joinCommunityNewUser
        if(inviteecode.isBlank()){
            return JoinCommunityNewUserResult(success = false, message = "Invitee code can not be empty")
        }
        return try {
            communityRepository.joinCommunity(joinCommunityNewUser)
        }catch (e: Exception){
            JoinCommunityNewUserResult(false, "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }
}