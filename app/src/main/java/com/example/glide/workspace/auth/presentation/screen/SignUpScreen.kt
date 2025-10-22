//package com.example.glide.workspace.auth.presentation.screen
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.glide.workspace.auth.presentation.viewmodel.AuthFormState
//import com.example.glide.workspace.auth.presentation.viewmodel.SignUpViewModel
//import com.example.glide.workspace.auth.domain.models.SignUpResult
//
//@Composable
//fun SignUpScreen(
//    viewModel: SignUpViewModel = viewModel()
//) {
//    val authFormState by viewModel.authFormState.collectAsState()
//    val signUpUiState by viewModel.signUpUiState.collectAsState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        // Name
//        OutlinedTextField(
//            value = authFormState.name,
//            onValueChange = { viewModel.onNameChange(it) },
//            label = { Text("Name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Email
//        OutlinedTextField(
//            value = authFormState.email,
//            onValueChange = { viewModel.onEmailChange(it) },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Phone
//        OutlinedTextField(
//            value = authFormState.phone,
//            onValueChange = { viewModel.onPhoneChange(it) },
//            label = { Text("Phone") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Password
//        OutlinedTextField(
//            value = authFormState.password,
//            onValueChange = { viewModel.onPasswordChange(it) },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Government ID
//        OutlinedTextField(
//            value = authFormState.governmentId,
//            onValueChange = { viewModel.onGovernmentIdChange(it) },
//            label = { Text("Government ID") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Government ID Type
//        OutlinedTextField(
//            value = authFormState.governmentIdType,
//            onValueChange = { viewModel.onGovernmentIdTypeChange(it) },
//            label = { Text("Government ID Type") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Age
//        OutlinedTextField(
//            value = authFormState.age,
//            onValueChange = { viewModel.onAgeChange(it) },
//            label = { Text("Age") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Gender
//        OutlinedTextField(
//            value = authFormState.gender,
//            onValueChange = { viewModel.onGenderChange(it) },
//            label = { Text("Gender") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Address
//        OutlinedTextField(
//            value = authFormState.address,
//            onValueChange = { viewModel.onAddressChange(it) },
//            label = { Text("Address") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Signup button
//        Button(
//            onClick = { viewModel.signUp() },
//            modifier = Modifier.fillMaxWidth(),
//            enabled = !signUpUiState.isLoading
//        ) {
//            Text(text = if (signUpUiState.isLoading) "Signing Up..." else "Sign Up")
//        }
//
//        // Show success / error
//        signUpUiState.message?.let { msg ->
//            Text(
//                text = msg,
//                color = if (signUpUiState.success) MaterialTheme.colorScheme.primary
//                else MaterialTheme.colorScheme.error,
//                modifier = Modifier.padding(top = 8.dp)
//            )
//        }
//    }
//}

package com.example.glide.workspace.auth.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.glide.Routes
import com.example.glide.workspace.auth.presentation.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val authFormState by viewModel.authFormState.collectAsState()
    val signUpUiState by viewModel.signUpUiState.collectAsState()

    // Navigate on success
    LaunchedEffect(signUpUiState.success) {
        if (signUpUiState.success) {
            navController.navigate(Routes.VERIFY_OTP) {
                popUpTo(Routes.SIGN_UP) { inclusive = true } // remove signup from backstack
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // --- Form fields ---
        OutlinedTextField(
            value = authFormState.name,
            onValueChange = { viewModel.onNameChange(it) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.phone,
            onValueChange = { viewModel.onPhoneChange(it) },
            label = { Text("Phone") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.governmentId,
            onValueChange = { viewModel.onGovernmentIdChange(it) },
            label = { Text("Government ID") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.governmentIdType,
            onValueChange = { viewModel.onGovernmentIdTypeChange(it) },
            label = { Text("Government ID Type") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.age,
            onValueChange = { viewModel.onAgeChange(it) },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.gender,
            onValueChange = { viewModel.onGenderChange(it) },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = authFormState.address,
            onValueChange = { viewModel.onAddressChange(it) },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.signUp() },
            modifier = Modifier.fillMaxWidth(),
            enabled = !signUpUiState.isLoading
        ) {
            Text(text = if (signUpUiState.isLoading) "Signing Up..." else "Sign Up")
        }

        signUpUiState.message?.let { msg ->
            Text(
                text = msg,
                color = if (signUpUiState.success) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}


@Composable
fun VerifyOtpScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Text(text = "Verify OTP", style = MaterialTheme.typography.headlineMedium)
    }
}