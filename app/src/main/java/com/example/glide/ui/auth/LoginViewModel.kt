package com.example.glide.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.domain.model.AuthResponse
import com.example.glide.domain.usecase.LoginUseCase
import com.example.glide.util.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginState = MutableStateFlow<AuthResult<AuthResponse>>(AuthResult.Loading)
    val loginState: StateFlow<AuthResult<AuthResponse>> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = AuthResult.Loading
            _loginState.value = loginUseCase(email, password)
        }
    }
}