package com.example.glide.workspace.community.domain.usecases

import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class FetchAllRolesOfCurrentCommunityUseCasey @Inject constructor(
    private val repository: CommunityRepository
) {
    suspend operator fun invoke() {

    }
}