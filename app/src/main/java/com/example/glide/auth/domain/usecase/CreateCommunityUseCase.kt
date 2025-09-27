package com.example.glide.auth.domain.usecase

import com.example.glide.auth.domain.model.CommunityCreationResult
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class CreateCommunityUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        phoneNumber: String,
        communityName: String
    ):  CommunityCreationResult {
        // Add business logic/validation if needed, e.g., validate inputs
        if (name.isBlank() || email.isBlank() || phoneNumber.isBlank() || communityName.isBlank()) {
            return CommunityCreationResult.Error("All fields are mandatory")
        }
        // Email/phone validation can be added here
        return authRepository.createCommunity(name, email, phoneNumber, communityName)
    }
}