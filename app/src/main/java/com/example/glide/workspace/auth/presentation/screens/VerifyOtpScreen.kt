package com.example.glide.workspace.auth.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

import com.example.glide.workspace.auth.presentation.viewmodels.VerifyOtpViewModel
import com.example.glide.workspace.core.composables.TextInputField

@Composable
fun VerifyOtpScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    userPhone: String,
    sessionId: String
) {
    val viewModel: VerifyOtpViewModel = hiltViewModel()
    val state by viewModel.state

    // Set phone and sessionId in viewModel - use LaunchedEffect to avoid multiple calls
    LaunchedEffect(userPhone, sessionId) {
        viewModel.userPhone = userPhone
        viewModel.sessionId = sessionId
    }

    // Navigate to home screen on successful OTP verification - use LaunchedEffect with condition
    LaunchedEffect(state.success) {
        if (state.success) {
            navController.navigate("home") {
                popUpTo("auth") { inclusive = true }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextInputField(
            value = state.otp,
            onValueChange = viewModel::otpChanged,
            label = "OTP",
            placeholder = "Enter 6-digit OTP"
        )
        if (state.error != null) {
            Text(state.error!!, color = MaterialTheme.colorScheme.error)
        }
        Button(onClick = viewModel::verifyOtp, enabled = !state.isLoading) {
            Text("Verify OTP")
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}