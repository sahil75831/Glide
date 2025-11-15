package com.example.glide.workspace.auth.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.models.User
import com.example.glide.workspace.auth.domain.usecases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterUserViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var governmentId by mutableStateOf("")
    var governmentIdType by mutableStateOf("") // default
    var age by mutableStateOf("")
    var gender by mutableStateOf("Male") // default
    var address by mutableStateOf("")

    // UI state
    var isLoading by mutableStateOf(false)
    var signUpResult by mutableStateOf<SignUpResult?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun signUp() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            signUpResult = null

            val user = User(
                name = name,
                phone = phone,
                email = email,
                password = password,
                governmentId = governmentId,
                governmentIdType = governmentIdType,
                age = age.toIntOrNull() ?: 0,
                gender = gender,
                address = address
            )

            val result = signUpUseCase(user)
            signUpResult = result
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