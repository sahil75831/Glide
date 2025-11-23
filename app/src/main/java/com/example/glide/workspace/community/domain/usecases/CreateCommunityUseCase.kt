package com.example.glide.workspace.community.domain.usecases

import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class CreateCommunityUseCase @Inject constructor(
    private val communityRepository: CommunityRepository
) {
    suspend operator fun invoke(createCommunityData: CreateCommunity): CreateCommunityResult {
        // DeStructure the properties
        val (name, address, city, state, pincode, country, description, type) = createCommunityData

        if (name.isBlank())
            return CreateCommunityResult(false, "Community name cannot be blank")

        if (address.isBlank())
            return CreateCommunityResult(false, "Address cannot be blank")

        if (city.isBlank())
            return CreateCommunityResult(false, "City cannot be blank")

        if (state.isBlank())
            return CreateCommunityResult(false, "State cannot be blank")

        if (pincode.isBlank())
            return CreateCommunityResult(false, "Pincode cannot be blank")

        if (!pincode.matches(Regex("^[0-9]{5,6}$")))
            return CreateCommunityResult(false, "Invalid pincode format")

        if (country.isBlank())
            return CreateCommunityResult(false, "Country cannot be blank")

        if (description.length < 10)
            return CreateCommunityResult(false, "Description must be at least 10 characters")

        if (type.isBlank())
            return CreateCommunityResult(false, "Please select a community type")

        return try {
            communityRepository.createCommunity(createCommunityData)
        }catch (e: Exception){
            CreateCommunityResult(false, "Unexpected error: ${e.localizedMessage ?: "Unknown"}")
        }
    }
}