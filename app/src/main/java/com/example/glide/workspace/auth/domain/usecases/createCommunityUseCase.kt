package com.example.glide.workspace.auth.domain.usecases

import com.example.glide.workspace.auth.domain.models.CommunityCreationResult
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import javax.inject.Inject

class createCommunityUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(userName:String, userPhone:String, userEmail:String, communityName:String): CommunityCreationResult {
        if(userName.isBlank() || userEmail.isBlank() || userPhone.isBlank() || communityName.isBlank()) {
            return CommunityCreationResult.Error("All fields are mandatory")
        }
        return authRepository.createCommunity(userName, userPhone, userEmail, communityName)
    }
}