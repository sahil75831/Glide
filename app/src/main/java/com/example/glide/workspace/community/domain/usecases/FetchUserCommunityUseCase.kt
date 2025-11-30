package com.example.glide.workspace.community.domain.usecases

import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository

class FetchUserCommunityUseCase(
    private val repository: CommunityRepository
){
    suspend operator fun invoke(): FetchUserCommunityResult {
        return repository.fetchUserCommunity()
    }
}

// NOTE WE SHOULD NOT USE TRY CATCH IN USE CASE BECAUSE IT VOILATES THE CLEAN ARCHITECTURE ONLY API SHOULD I TRY CATCH THAT ERROR HANDLING

