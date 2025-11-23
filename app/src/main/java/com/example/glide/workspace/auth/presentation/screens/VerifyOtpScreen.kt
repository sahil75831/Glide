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
import com.example.glide.workspace.auth.presentation.viewModels.OtpViewModel
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryInputField

@Composable
fun OtpScreen(
    phone: String = "438473434",
    email: String = "ekfbckfc",
    modifier: Modifier = Modifier,
    viewModel: OtpViewModel = hiltViewModel(),
    onSuccess: () -> Unit = {},
    onBack: () ->  Unit = {},

) {
    val scrollState = rememberScrollState()
    // 🔥 Store navigation arguments INSIDE ViewModel only once
    LaunchedEffect(Unit) {
        viewModel.phone = phone
        viewModel.email = email
    }

    Column(modifier = modifier.fillMaxSize()) {
        Column {
            Text(
                text = "Verify",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Enter respective otp",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Column {
            Image(
                painter = painterResource(id = R.drawable.verify_otp),
                contentDescription = "Welcome Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.3f)
            )

        }
        // Content area --main body
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
                .verticalScroll(scrollState)
        ) {
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Phone number",
                    enabled = false,
                    value = phone,
                    supportingText = ""
                )
            }
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Phone otp",
                    placeHolder = "Enter otp sent on mobile",
                    value = viewModel.phoneOtp,
                    // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//                    isError = viewModel.phoneOtp.isBlank(),
                    onValueChange = {viewModel.phoneOtp = it},
                    supportingText = ""
                )
            }

            // --email
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Email Id",
                    enabled = false,
                    value = email,
                    supportingText = ""
                )
            }
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Email otp",
                    placeHolder = "Enter otp sent on email",
                    value = viewModel.emailOtp,
                    // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    // isError = viewModel.emailOtp.isBlank() ,
                    onValueChange = {viewModel.emailOtp = it},
                    supportingText = ""
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryButton(
                    onClick = {viewModel.verifyOtp()},
                    enabled = if (
                        viewModel.phoneOtp.isNotBlank() && viewModel.emailOtp.isNotBlank()) {
                        true
                    } else false,
                    isLoading = viewModel.isLoading,
                    text = "Verify"
                )
            }
            Row(modifier = modifier.padding(8.dp)) {
                Text(
                    text = "Resend OTP",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }

            LaunchedEffect(viewModel.verifyOtpResult) {
                val result = viewModel.verifyOtpResult
                if(result !=null && result.success){
                    onSuccess()
                }
            }
        }
    }

}