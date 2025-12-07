package com.example.glide.workspace.community.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.community.domain.models.CommunityMembership
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUser
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUserResult
import com.example.glide.workspace.community.domain.usecases.FetchUserCommunityUseCase
import com.example.glide.workspace.community.domain.usecases.JoinCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinExploreCommunityViewModel @Inject constructor(
    private val fetchUserCommunityUseCase: FetchUserCommunityUseCase,
    private val joinCommunityUseCase: JoinCommunityUseCase
): ViewModel() {
    var inviteeCode by mutableStateOf("")

    // UI STATE
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)
    var fetchUserCommunityResult by mutableStateOf<FetchUserCommunityResult?>(null)

    // Separate states for owner and member communities
    var ownerCommunities by mutableStateOf<List<CommunityMembership>>(emptyList())
    var memberCommunities by mutableStateOf<List<CommunityMembership>>(emptyList())

    // Join community specific states
    var joinCommunityResult by mutableStateOf<JoinCommunityNewUserResult?>(null)
    var joinCommunityLoading by mutableStateOf<Boolean>(false)
    var joinCommunityErrorMessage by mutableStateOf<String?>(null)
    var joinSuccess by mutableStateOf<Boolean>(false)


    init {
        getAllCommunities()
    }

    fun joinCommunity(){
       if(inviteeCode.isBlank()){
           joinCommunityErrorMessage = "Invitee code is blank"
           return
       }
        viewModelScope.launch {
            joinCommunityLoading = true
            joinCommunityErrorMessage = null
            joinSuccess = false

            try {
                val joinCommunityRequest = JoinCommunityNewUser(inviteeCode)
                val result = joinCommunityUseCase(joinCommunityRequest)
                joinCommunityResult = result

                if(result.success){
                    joinSuccess = true
                    getAllCommunities()
                    // Clear the invite code after successful join
                    inviteeCode = ""
                }else{
                    joinCommunityErrorMessage = result.message
                }
            }catch (e: Exception){
                joinCommunityErrorMessage = "Failed to join community: ${e.message}"
            } finally {
                joinCommunityLoading = false
            }
        }
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