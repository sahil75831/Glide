package com.example.glide.workspace.auth.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.data.remote.dto.AuthRequest
import com.example.glide.workspace.auth.domain.models.SignUpResult
import com.example.glide.workspace.auth.domain.usecases.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// --- UI Form State ---
data class AuthFormState(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val governmentId: String = "",
    val governmentIdType: String = "",
    val age: String = "",
    val gender: String = "",
    val address: String = ""
)

// --- UI SignUp Result State ---
data class SignUpUiState(
    val isLoading: Boolean = false,
    val success: Boolean = false,
    val message: String? = null
)

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    // --- Form State ---
    private val _authFormState = MutableStateFlow(AuthFormState())
    val authFormState: StateFlow<AuthFormState> = _authFormState.asStateFlow()

    // --- Signup UI State ---
    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState: StateFlow<SignUpUiState> = _signUpUiState.asStateFlow()

    // --- Update individual fields ---
    fun onNameChange(value: String) = updateFormState { copy(name = value) }
    fun onEmailChange(value: String) = updateFormState { copy(email = value) }
    fun onPhoneChange(value: String) = updateFormState { copy(phone = value) }
    fun onPasswordChange(value: String) = updateFormState { copy(password = value) }
    fun onGovernmentIdChange(value: String) = updateFormState { copy(governmentId = value) }
    fun onGovernmentIdTypeChange(value: String) = updateFormState { copy(governmentIdType = value) }
    fun onAgeChange(value: String) = updateFormState { copy(age = value) }
    fun onGenderChange(value: String) = updateFormState { copy(gender = value) }
    fun onAddressChange(value: String) = updateFormState { copy(address = value) }

    private fun updateFormState(update: AuthFormState.() -> AuthFormState) {
        _authFormState.value = _authFormState.value.update()
    }

    // --- Sign Up ---
    fun signUp() {
        viewModelScope.launch {
            _signUpUiState.value = SignUpUiState(isLoading = true)
            try {
                val form = _authFormState.value
                if (form.age.isBlank() || form.age.toIntOrNull() == null) {
                    _signUpUiState.value = SignUpUiState(
                        isLoading = false,
                        success = false,
                        message = "Please enter a valid age"
                    )
                    return@launch
                }

                val request = AuthRequest(
                    name = form.name,
                    email = form.email,
                    phone = form.phone,
                    password = form.password,
                    governmentId = form.governmentId,
                    governmentIdType = form.governmentIdType,
                    age = form.age.toInt(),
                    gender = form.gender,
                    address = form.address
                )

                val result = signUpUseCase(request)

                Log.d("SignUpViewModel", "Sign up result: $result")

                when (result) {
                    is SignUpResult.Success -> {
                        _signUpUiState.value = SignUpUiState(
                            isLoading = false,
                            success = true,
                            message = result.message
                        )
                    }
                    is SignUpResult.Error -> {
                        _signUpUiState.value = SignUpUiState(
                            isLoading = false,
                            success = false,
                            message = result.message
                        )
                    }
                }

            } catch (e: Exception) {
                _signUpUiState.value = SignUpUiState(
                    isLoading = false,
                    success = false,
                    message = e.message ?: "Unexpected error occurred"
                )
            }
        }
    }

    // --- Reset form and UI state ---
    fun resetForm() {
        _authFormState.value = AuthFormState()
        _signUpUiState.value = SignUpUiState()
    }
}
