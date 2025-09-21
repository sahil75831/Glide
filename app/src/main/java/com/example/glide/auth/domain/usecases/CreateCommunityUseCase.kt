package com.example.glide.auth.domain.usecases

import com.example.glide.auth.data.models.User
import com.example.glide.auth.domain.repository.AuthRepository
import javax.inject.Inject

class CreateCommunityUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: User):Result<String> {
        // De-structure the user object
        val ( name, email, phone, communityName, roleId, accessId) = user
        // Debug logging: Print all de structured fields
        println("name, email, phone, communityName, roleId, accessId: $name, $email, $phone, $communityName, $roleId, $accessId")

        // Business rule validations using destructured variables
        if(name.isBlank()) return Result.failure(exception = Exception("User name can not be black"))
        if(email.isBlank() || !email.contains("@")) return Result.failure(exception = Exception("Invalid user email"))
        if(phone.isBlank()) return Result.failure(exception = Exception("User phone number can not be blank"))
        if(communityName.isNullOrBlank()) return Result.failure(exception = Exception("Community name can not be black"))

        // Optional: Log after validation passes
        println("Validation passed for user: $name (email: $email)")

        return authRepository.createCommunity(user)
    }
}