package com.example.glide.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.util.AuthResult

@Composable
fun ForgotPasswordScreen(navController: NavController, viewModel: ForgotPasswordViewModel = hiltViewModel()) {
    var email by remember { mutableStateOf("") }
    val state by viewModel.forgotState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.forgotPassword(email) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Reset Link")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { navController.popBackStack() }
        ) {
            Text("Back to Login")
        }

        when (state) {
            is AuthResult.Loading -> {
                CircularProgressIndicator()
            }
            is AuthResult.Success -> {
                Text("Reset link sent to your email!")
            }
            is AuthResult.Error -> {
                val error = state as AuthResult.Error
                Text(
                    text = "Error: ${error.message}",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}