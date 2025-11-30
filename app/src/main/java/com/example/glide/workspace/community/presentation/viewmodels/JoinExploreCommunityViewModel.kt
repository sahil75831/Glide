package com.example.glide.workspace.community.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.community.domain.models.CommunityMembership
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.usecases.FetchUserCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinExploreCommunityViewModel @Inject constructor(
    private val fetchUserCommunityUseCase: FetchUserCommunityUseCase
): ViewModel() {
    var inviteeCode by mutableStateOf("")

    // UI STATE
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)
    var fetchUserCommunityResult by mutableStateOf<FetchUserCommunityResult?>(null)

    // Separate states for owner and member communities
    var ownerCommunities by mutableStateOf<List<CommunityMembership>>(emptyList())
    var memberCommunities by mutableStateOf<List<CommunityMembership>>(emptyList())


    init {
        getAllCommunities()
    }

    fun joinCommunity(){
        // to be implemented
    }

    fun getAllCommunities(){
        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            val allCommunitiesResult = fetchUserCommunityUseCase()
            fetchUserCommunityResult = allCommunitiesResult

            if(allCommunitiesResult.success) {
                // Filter communities based on role
                val communities = allCommunitiesResult.communities

                ownerCommunities = communities.filter {
                    it.role.name.equals("Community Admin", ignoreCase = true)
                }

                // FIXED: Use the same case-insensitive comparison
                memberCommunities = communities.filter {
                    !it.role.name.equals("Community Admin", ignoreCase = true)
                }
            } else {
                errorMessage = allCommunitiesResult.message
            }
            isLoading = false
        }
    }

    fun clearError() {
        errorMessage = null
    }

    fun retry() {
        getAllCommunities()
    }
}