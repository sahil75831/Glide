package com.example.glide.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.domain.usecase.ForgotPasswordUseCase
import com.example.glide.util.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val forgotPasswordUseCase: ForgotPasswordUseCase
) : ViewModel() {
    private val _forgotState = MutableStateFlow<AuthResult<Unit>>(AuthResult.Loading)
    val forgotState: StateFlow<AuthResult<Unit>> = _forgotState

    fun forgotPassword(email: String) {
        viewModelScope.launch {
            _forgotState.value = AuthResult.Loading
            _forgotState.value = forgotPasswordUseCase(email)
        }
    }
}