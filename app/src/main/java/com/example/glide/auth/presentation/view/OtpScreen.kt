package com.example.glide.auth.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.auth.presentation.viewmodel.AuthViewModel

@Composable
fun OtpScreen(
    phone: String,
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var otp by remember { mutableStateOf("") }

    Column {
        Text("Enter OTP sent to $phone")
        TextField(value = otp, onValueChange = { otp = it }, label = { Text("OTP") })
        Button(onClick = {
            viewModel.verifyOtp(phone, otp)
        }) {
            Text("Verify")
        }
        val verifyState by viewModel.verifyOtpState.collectAsState()
        verifyState?.let { result ->
            if (result.isFailure) {
                Text("Error: ${result.exceptionOrNull()?.message ?: "Unknown error"}")
            }
        }
    }

    val verifyState by viewModel.verifyOtpState.collectAsState()
    LaunchedEffect(verifyState) {
        verifyState?.let { result ->
            if (result.isSuccess) {
                navController.navigate("home")
                viewModel.resetVerifyState()
            }
        }
    }
}