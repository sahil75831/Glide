package com.example.glide.auth.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.auth.domain.model.OtpVerificationResult
import com.example.glide.auth.domain.usecase.VerifyOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerifyOtpState(
    val otp: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

@HiltViewModel
class VerifyOtpViewModel @Inject constructor(
    private val verifyOtpUseCase: VerifyOtpUseCase
): ViewModel() {
    private val _state = mutableStateOf(VerifyOtpState())
    val state: State<VerifyOtpState> = _state

    var sessionId: String = ""
    var phoneNumber: String = ""

    fun onOtpChanged(otp: String){
        _state.value = _state.value.copy(otp = otp)
    }

    fun verifyOtpChanged() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            val result = verifyOtpUseCase(
                sessionId,
                _state.value.otp,
                phoneNumber

            )
            when (result){
                is OtpVerificationResult.Success -> {
                    // Save token if needed e.g., in datastore
                    _state.value = _state.value.copy(
                        isLoading = false,
                        success = true
                    )
                }
                is OtpVerificationResult.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}