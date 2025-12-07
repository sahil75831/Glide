package com.example.glide.workspace.community.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.community.data.local.CommunityLocalDataSource
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRole
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.domain.usecases.CreateCurrentCommunityRoleUseCase
import com.example.glide.workspace.community.domain.usecases.FetchAllPermissionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateNewRoleViewModel @Inject constructor(
    private val createCurrentCommunityRoleUseCase: CreateCurrentCommunityRoleUseCase,
    private val fetchAllPermissionsUseCase: FetchAllPermissionsUseCase,
    private val communityLocalDataSource: CommunityLocalDataSource
): ViewModel() {

    var communityId by mutableStateOf<String?>(null)

    var roleName by mutableStateOf<String>("")
    var description by mutableStateOf<String>("")
    var allPermissions by mutableStateOf<List<String>>(emptyList())
    var permissionKeys by mutableStateOf<List<String>>(emptyList())
        private set // Make setter private to control modification

    // UI STATE
    var isLoading by mutableStateOf<Boolean>(false)
    var errorMessage by mutableStateOf<String?>(null)
    var createCurrentCommunityRoleResult by mutableStateOf<CreateCurrentCommunityRoleResult?>(null)


    init {
        loadAllRolesOfCurrentCommunity()
        viewModelScope.launch {
            val permissionKeysObjList = fetchAllPermissionsUseCase()
            if(permissionKeysObjList.success){
                allPermissions = permissionKeysObjList.permissions
                    .filterNotNull()   // remove nulls safely
                    .map { it.key }
            }else{
                allPermissions = emptyList()
            }

        }
    }

    private fun loadAllRolesOfCurrentCommunity(){

    }

    private fun loadCommunityId() {
        communityId = communityLocalDataSource.getCurrentCommunityId()
    }


    fun setCommunityIdHeader(communityId: String) {
        this.communityId = communityId
        // Save for future use
        communityLocalDataSource.saveCurrentCommunityId(communityId)
    }


    // Methods to manage permissionKeys for multi-select dropdown
    fun addPermission(permission: String) {
        if (!permissionKeys.contains(permission)) {
            permissionKeys = permissionKeys + permission
        }
    }

    fun removePermission(permission: String) {
        permissionKeys = permissionKeys - permission
    }

    fun clearAllPermissions() {
        permissionKeys = emptyList()
    }

    // Optional: Method to check if form is valid for button enable/disable
    fun isFormValid(): Boolean {
        return roleName.isNotBlank() &&
                description.isNotBlank() &&
                permissionKeys.isNotEmpty()
    }

    // Optional: Reset entire form
    fun resetForm() {
        roleName = ""
        description = ""
        permissionKeys = emptyList()
        errorMessage = null
        createCurrentCommunityRoleResult = null
    }

    fun createCurrentCommunityRole() {
        // Only proceed if form is valid
        if (!isFormValid()) {
            errorMessage = "Please fill all required fields and select at least one permission"
            return
        }

        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            createCurrentCommunityRoleResult = null

            try {
                val newRoleForCurrentCommunity = CreateCurrentCommunityRole(
                    name = roleName,
                    description = description,
                    permissionKeys = permissionKeys
                )
                val result = createCurrentCommunityRoleUseCase(newRoleForCurrentCommunity)
                createCurrentCommunityRoleResult = result

                if (!result.success) {
                    errorMessage = result.message
                } else {
                    // Optionally reset form on success
                    // resetForm()
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun clearError() {
        errorMessage = null
    }
}