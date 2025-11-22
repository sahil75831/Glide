package com.example.glide.workspace.auth.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.domain.models.LoginUser
import com.example.glide.workspace.auth.domain.models.LoginUserResult
import com.example.glide.workspace.auth.domain.usecases.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginUserViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase
): ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    // UI STATE
    var isLoading by mutableStateOf(false)
    var loginUserResult by mutableStateOf<LoginUserResult?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun loginUser() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            loginUserResult = null

            val loginUser = LoginUser(
                email = email,
                password = password
            )

            val result = loginUserUseCase(loginUser)
            loginUserResult = result
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