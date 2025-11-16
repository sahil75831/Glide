package com.example.glide.workspace.auth.presentation.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.domain.models.VerifyOtp
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult
import com.example.glide.workspace.auth.domain.usecases.VerifyOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(
    private val verifyOtpUseCase: VerifyOtpUseCase
): ViewModel() {
    var phone by mutableStateOf("")
    var phoneOtp by mutableStateOf("")
    var email by mutableStateOf("")
    var emailOtp by mutableStateOf("")

    // UI state
    var isLoading by mutableStateOf(false)
    var verifyOtpResult by mutableStateOf<VerifyOtpResult?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun verifyOtp(){
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            verifyOtpResult = null

            val verifyOtpData = VerifyOtp(
                phone = phone,
                phoneOtp = phoneOtp,
                email = email,
                emailOtp = emailOtp
            )

            val result = verifyOtpUseCase(verifyOtpData)
            verifyOtpResult = result
            if(!result.success){
                errorMessage = errorMessage
            }
            isLoading = false
        }
    }

    // fun to clear error messages
    fun clearError() {
        errorMessage = null
    }
}