package com.example.glide.workspace.community.domain.usecases


import com.example.glide.workspace.community.domain.models.FetchAllPermissionsResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class FetchAllPermissionsUseCase @Inject constructor(
    private val repository: CommunityRepository
) {
    suspend operator fun invoke(): FetchAllPermissionsResult {
        return try {
            repository.fetchAllPermissions()
        } catch (e: Exception) {
            // You can also log the error if needed
            FetchAllPermissionsResult(
                success = false,
                message = e.message ?: "Unknown error occurred",
                permissions = emptyList()
            )
        }
    }
}
