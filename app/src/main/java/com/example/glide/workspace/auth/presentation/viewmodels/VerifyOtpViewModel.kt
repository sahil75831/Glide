package com.example.glide.workspace.auth.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.data.local.AuthDataStore
import com.example.glide.workspace.auth.domain.models.OtpVerificationResult
import com.example.glide.workspace.auth.domain.usecases.VerifyOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerifyOtpState(
    val otp: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false,

)

@HiltViewModel
class VerifyOtpViewModel @Inject constructor(
    private val verifyOtpUseCase: VerifyOtpUseCase,
    private val authDataStore: AuthDataStore
): ViewModel() {
    private val _state:MutableState<VerifyOtpState> = mutableStateOf(VerifyOtpState())
    val state: State<VerifyOtpState> = _state

    var sessionId: String = ""
    var userPhone: String = ""

    fun otpChanged(otp: String) {
        if(otp.length <= 6){
            _state.value = _state.value.copy(otp = otp, error = null)
        }else{
            _state.value = _state.value.copy(
                otp = otp,
                error = "OTP must be 6 digits"
            )
        }
    }

    fun verifyOtp(){
        viewModelScope.launch {
            if(_state.value.otp.length != 6){
                _state.value = _state.value.copy(error = "OTP must be 6 digits")
                return@launch
            }
            _state.value = _state.value.copy(isLoading = true, error = null)
            val result = verifyOtpUseCase(userPhone, _state.value.otp, sessionId)

            when (result) {
                is OtpVerificationResult.Success -> {
                    // Save token securely
                    authDataStore.saveToken(result.token)
                    // Log analytics event (e.g., Firebase Analytics)
                    // analytics.logEvent("otp_verification_success", bundleOf("phoneNumber" to phoneNumber))
                    _state.value = _state.value.copy(
                        isLoading = false,
                        success = true,
                        error = null
                    )
                }
                is OtpVerificationResult.Error -> {
                    // Log analytics event
                    // analytics.logEvent("otp_verification_failed", bundleOf("error" to result.message))
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = when (result.message) {
                            "Invalid OTP" -> "Incorrect OTP. Please try again."
                            "Session expired" -> "Session expired. Please request a new OTP."
                            else -> result.message
                        }
                    )
                }

            }
        }
    }
}