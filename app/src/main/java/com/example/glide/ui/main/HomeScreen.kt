package com.example.glide.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.glide.domain.usecase.LogoutUseCase
import com.example.glide.util.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val logoutUseCase: LogoutUseCase) : androidx.lifecycle.ViewModel() {
    private val _logoutState = MutableStateFlow<AuthResult<Unit>?>(null)
    val logoutState: StateFlow<AuthResult<Unit>?> = _logoutState

    fun logout() {
        viewModelScope.launch {
            _logoutState.value = AuthResult.Loading
            _logoutState.value = logoutUseCase.invoke()
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val logoutState by viewModel.logoutState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Welcome to Home!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { viewModel.logout() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }

        when (val state = logoutState) {
            is AuthResult.Loading -> CircularProgressIndicator(modifier = Modifier.size(20.dp))
            is AuthResult.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate("login") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            }
            is AuthResult.Error -> {
                Text(
                    text = "Logout failed: ${state.message}",
                    color = MaterialTheme.colorScheme.error
                )
            }
            null -> {}
        }
    }
}