package com.example.glide.workspace.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.R
import com.example.glide.workspace.auth.presentation.viewModels.LoginUserViewModel
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryInputField

@Composable
fun LoginUserScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginUserViewModel = hiltViewModel(),
    onSuccess: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxSize()) {
        Column {
            Text(
                text = "Login",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Hi, Login to your account",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = painterResource(id = R.drawable.login_screen),
                contentDescription = "Login Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxHeight(0.3f)
                    .align(Alignment.CenterHorizontally),
            )

        }

        // content area --main body
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
                .verticalScroll(scrollState)
        ) {
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Email",
                    placeHolder = "e.g emily.smith@example.com",
                    value = viewModel.email,
                    onValueChange = {viewModel.email = it},
                    supportingText = ""
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Password",
                    placeHolder = "Type your password here ..",
                    value = viewModel.password,
                    onValueChange = { viewModel.password = it }, // ← Fixed: was setting email!
                    isError = viewModel.password.isNotBlank() && viewModel.password.length < 4,
                    supportingText = if (viewModel.password.isNotBlank() && viewModel.password.length < 4) {
                        "Password should be greater than 4 characters"
                    } else { "" },
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryButton(
                    onClick = {viewModel.loginUser()},
                    enabled = if (
                        viewModel.email.isNotBlank() && viewModel.password.isNotBlank()
                    ) {
                        true
                    } else false,
                    isLoading = viewModel.isLoading,
                    text = "Login"
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                Text(
                    text = "Don't have an account? Sign up",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }


            // Error Message
            viewModel.errorMessage?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
            }

            // Success → Navigate
            LaunchedEffect (viewModel.loginUserResult) {
                    viewModel.loginUserResult?.let { result ->
                        if(result.success){
                            onSuccess()
                        }
                    }
                }
            }
        }
    }