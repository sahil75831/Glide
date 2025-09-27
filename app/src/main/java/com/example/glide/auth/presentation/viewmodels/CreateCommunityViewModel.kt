package com.example.glide.auth.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.auth.domain.model.CommunityCreationResult
import com.example.glide.auth.domain.usecase.CreateCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class CreateCommunityState(
    val name: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val communityName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val sessionId: String? = null
)


@HiltViewModel
class CreateCommunityViewModel @Inject constructor(
    private val createCommunityUseCase: CreateCommunityUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CreateCommunityState())
    val state: State<CreateCommunityState> = _state

    fun onNameChanged(name: String){
        _state.value = _state.value.copy(name = name)
    }

    fun onEmailChanged(email: String){
        _state.value = _state.value.copy(email = email)
    }

    fun onPhoneNumberChanged(phoneNumber: String){
        _state.value = _state.value.copy(phoneNumber = phoneNumber)
    }

    fun onCommunityNameChanged(communityName: String){
        _state.value = _state.value.copy(communityName = communityName)
    }

    fun createCommunity(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            val result = createCommunityUseCase(
                _state.value.name,
                _state.value.email,
                _state.value.phoneNumber,
                _state.value.communityName
            )

            when(result){
                is CommunityCreationResult.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        sessionId = result.sessionId
                    )
                }
                is CommunityCreationResult.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }


        }
    }
}