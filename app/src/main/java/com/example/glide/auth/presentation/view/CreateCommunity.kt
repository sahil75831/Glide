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
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.auth.data.models.User
import com.example.glide.auth.presentation.viewmodel.AuthViewModel

@Composable
fun CreateCommunityScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var communityName by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
        TextField(value = communityName, onValueChange = { communityName = it }, label = { Text("Community Name") })
        Button(onClick = {
            viewModel.createCommunity(User(name, email, phone, communityName))
        }) {
            Text("Create")
        }
        val createState by viewModel.createCommunityState.collectAsState()
        createState?.let { result ->
            if (result.isFailure) {
                Text("Error: ${result.exceptionOrNull()?.message ?: "Unknown error"}")
            }
        }
    }

    val createState by viewModel.createCommunityState.collectAsState()
    LaunchedEffect(createState) {
        createState?.let { result ->
            if (result.isSuccess) {
                navController.navigate("otp/$phone")
                viewModel.resetCreateState()
            }
        }
    }
}