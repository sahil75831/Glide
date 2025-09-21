package com.example.glide.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.auth.data.models.User
import com.example.glide.auth.domain.usecases.CreateCommunityUseCase
import com.example.glide.auth.domain.usecases.VerifyOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val createCommunityUseCase: CreateCommunityUseCase,
    private val verifyOtpUseCase: VerifyOtpUseCase
) : ViewModel() {
    private val _createCommunityState = MutableStateFlow<Result<String>?>(null)
    val createCommunityState: StateFlow<Result<String>?> = _createCommunityState

    private val _verifyOtpState = MutableStateFlow<Result<String>?>(null)
    val verifyOtpState: StateFlow<Result<String>?> = _verifyOtpState

    fun createCommunity(user: User) {
        viewModelScope.launch {
            _createCommunityState.value = createCommunityUseCase(user)
        }
    }

    fun verifyOtp(phone: String, otp: String) {
        viewModelScope.launch {
            _verifyOtpState.value = verifyOtpUseCase(phone, otp)
        }
    }

    fun resetCreateState() {
        _createCommunityState.value = null
    }

    fun resetVerifyState() {
        _verifyOtpState.value = null
    }
}