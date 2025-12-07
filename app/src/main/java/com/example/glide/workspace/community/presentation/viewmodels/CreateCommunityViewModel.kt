package com.example.glide.workspace.community.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.usecases.CreateCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateCommunityViewModel @Inject constructor(
    private val createCommunityUseCase: CreateCommunityUseCase
): ViewModel() {
    var name by mutableStateOf("")
    var address by mutableStateOf("")
    var city by mutableStateOf("")
    var state by mutableStateOf("")
    var pincode by mutableStateOf("")
    var country by mutableStateOf("")
    var description by mutableStateOf("")
    var type by mutableStateOf("")

    // UI STATE
    var isLoading by mutableStateOf(false)
    var createCommunityResult by mutableStateOf<CreateCommunityResult?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun createCommunity(){
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            createCommunityResult = null

            val newCommunity = CreateCommunity(
                name = name,
                address = address,
                city = city,
                state = state,
                pincode = pincode,
                country = country,
                description = description,
                type = type
            )

            val result = createCommunityUseCase(newCommunity)
            createCommunityResult = result

            if(!result.success){
                errorMessage = result.message
            }
            isLoading = false

        }
    }

    fun clearError() {
        errorMessage = null
    }
}