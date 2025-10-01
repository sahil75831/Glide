package com.example.glide.workspace.auth.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.auth.domain.models.CommunityCreationResult
import com.example.glide.workspace.auth.domain.usecases.createCommunityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CreateCommunityState(
    val userName: String = "",
    val userEmail: String = "",
    val userPhone: String = "",
    val communityName: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val sessionId: String? = null
)

@HiltViewModel
class CreateCommunityViewModel @Inject constructor(private  val createCommunityUseCase: createCommunityUseCase): ViewModel() {
    private val _state: MutableState<CreateCommunityState> = mutableStateOf(CreateCommunityState())
    val state: State<CreateCommunityState> = _state

    fun onNameChanged(name: String){
        _state.value = _state.value.copy(userName = name)
    }

    fun onEmailChanged(email: String){
        _state.value = _state.value.copy(userEmail = email)
    }

    fun onPhoneNumberChanged(phoneNumber: String){
        _state.value = _state.value.copy(userPhone = phoneNumber)
    }

    fun onCommunityNameChanged(communityName: String){
        _state.value = _state.value.copy(communityName = communityName)
    }

    fun createCommunity(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)

            val result = createCommunityUseCase(
                _state.value.userName,
                _state.value.userPhone,
                _state.value.userEmail,
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