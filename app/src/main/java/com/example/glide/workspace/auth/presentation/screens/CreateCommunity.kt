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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.glide.workspace.auth.presentation.viewmodels.CreateCommunityViewModel
import com.example.glide.workspace.core.composables.TextInputField

@Composable
fun CreateCommunity(modifier: Modifier = Modifier, navController: NavHostController) {
    val viewModel: CreateCommunityViewModel = hiltViewModel()
    val state by viewModel.state

    // Use LaunchedEffect to navigate only when sessionId becomes non-null
    LaunchedEffect(state.sessionId) {
        if (state.sessionId != null) {
            navController.navigate("verify_otp/${state.userPhone}/${state.sessionId}")
        }
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextInputField(
            value = state.userName,
            onValueChange = viewModel::onNameChanged,
            label = "Name",
            placeholder = "Enter your name"
        )
        TextInputField(
            value = state.userEmail,
            onValueChange = viewModel::onEmailChanged,
            label = "Email",
            placeholder = "Enter your email"
        )
        TextInputField(
            value = state.userPhone,
            onValueChange = viewModel::onPhoneNumberChanged,
            label = "Phone Number",
            placeholder = "Enter your phone number"
        )
        TextInputField(
            value = state.communityName,
            onValueChange = viewModel::onCommunityNameChanged,
            label = "Community Name",
            placeholder = "Enter community name"
        )
        if (state.error != null) {
            Text(state.error!!, color = MaterialTheme.colorScheme.error)
        }
        Button(onClick = viewModel::createCommunity, enabled = !state.isLoading) {
            Text("Create Community")
        }
        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}