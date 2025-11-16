package com.example.glide.workspace.auth.presentation.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.workspace.auth.presentation.viewModels.RegisterUserViewModel
import com.example.glide.workspace.core.components.DropDownVariant
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryDropdown
import com.example.glide.workspace.core.components.ThemedPrimaryInputField
import com.example.glide.workspace.ui.theme.AppTheme

@Composable
fun RegisterUserScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterUserViewModel = hiltViewModel(),
    onSuccess: (String, String) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxSize()) {
       Column {
           Text(
               text = "Register",
               modifier = modifier
                   .fillMaxWidth(),
               fontSize = 32.sp,
               fontWeight = FontWeight.SemiBold,
               textAlign = TextAlign.Center,
               color = MaterialTheme.colorScheme.primary
           )
           Text(
               text = "Hi, Create your account",
               modifier = modifier
                   .fillMaxWidth(),
               fontSize = 16.sp,
               fontWeight = FontWeight.Normal,
               fontStyle = FontStyle.Italic,
               textAlign = TextAlign.Center,
               color = MaterialTheme.colorScheme.primary
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
                    label = "Full name",
                    placeHolder = "e.g Emily smith",
                    value = viewModel.name,
                    onValueChange = {viewModel.name = it},
                    supportingText = ""
                )
            }
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField (
                    variant = InputFieldVariant.Filled,
                    label = "Phone number",
                    placeHolder = "e.g. 9823XXXXXX",
                    value = viewModel.phone,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    isError = viewModel.phone.isNotBlank() && !viewModel.phone.matches(Regex("^[6-9][0-9]{9}\$")),
                    onValueChange = {viewModel.phone = it},
                    supportingText = if ( viewModel.phone.isNotBlank() && !viewModel.phone.matches(Regex("^[6-9][0-9]{9}\$"))){
                            "Invalid phone number"
                        } else {""}
                )
            }
            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Email",
                    placeHolder = "e.g. emily.smith@example.com",
                    value = viewModel.email,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = viewModel.email.isNotBlank() &&
                            (viewModel.email.length < 3 || !android.util.Patterns.EMAIL_ADDRESS.matcher(viewModel.email).matches()),
                    onValueChange = { viewModel.email = it },
                    supportingText = if (viewModel.email.isNotBlank() &&
                        (viewModel.email.length < 3 || !android.util.Patterns.EMAIL_ADDRESS.matcher(viewModel.email).matches())) {
                        "Invalid email address"
                    } else { "" }
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryDropdown(
                    variant = DropDownVariant.Filled,
                    selectedItem = viewModel.governmentIdType,
                    items = listOf("Aadhaar", "PAN Card", "Passport", "Voter ID", "Driving License"),
                    onItemSelected = {viewModel.governmentIdType = it},
                    label = "Government ID Type",
                    placeholder = "e.g. Aadhar",
                    isError = viewModel.governmentId.isNotBlank() && viewModel.governmentIdType.isBlank(),
                    supportingText = if(viewModel.governmentId.isNotBlank() && viewModel.governmentIdType.isBlank()) "Please select ID type" else ""
                )
            }


            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Govt ID",
                    placeHolder = "e.g. Aadhaar, PAN, Passport No.",
                    value = viewModel.governmentId,
                    onValueChange = { viewModel.governmentId = it }, // ← Fixed: was setting email!
                    isError = viewModel.governmentId.isNotBlank() && viewModel.governmentId.length < 4,
                    supportingText = if (viewModel.governmentId.isNotBlank() && viewModel.governmentId.length < 4) {
                        "ID must be at least 4 characters"
                    } else { "" }
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryDropdown(
                    variant = DropDownVariant.Filled,
                    selectedItem = viewModel.age,
                    items = (18..110).map { it.toString() }, // List<String>,
                    onItemSelected = {viewModel.age = it},
                    label = "Age",
                    placeholder = "Select your age..",
                )
            }


            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Address",
                    placeHolder = "Type your address here ..",
                    value = viewModel.address,
                    onValueChange = { viewModel.address = it }, // ← Fixed: was setting email!
                    isError = viewModel.address.isNotBlank() && viewModel.address.length < 4,
                    supportingText = if (viewModel.address.isNotBlank() && viewModel.address.length < 4) {
                        "Address should be greater than 10 characters long"
                    } else { "" },
                    singleLine = false,
                    maxLines = 2,

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
                        "Password should be greater than 5 characters"
                    } else { "" },
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                ThemedPrimaryButton(
                    onClick = {viewModel.signUp()},
                    enabled = if (
                        viewModel.name.isNotBlank() && viewModel.age.isNotBlank() && viewModel.email.isNotBlank() && viewModel.address.isNotBlank() && viewModel.governmentId.isNotBlank() && viewModel.governmentIdType.isNotBlank() && viewModel.phone.isNotBlank()
                    ) {
                        true
                    } else false,
                    isLoading = viewModel.isLoading,
                    text = "Sign Up"
                )
            }

            Row(modifier = modifier.padding(8.dp)) {
                Text(
                    text = "Already have an account? Sign in",
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
            LaunchedEffect (viewModel.signUpResult) {
                viewModel.signUpResult?.let { result ->
                    if (result.success) {
                        onSuccess(viewModel.phone, viewModel.email)
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterUserScreen() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            RegisterUserScreen()
        }
    }
}

// Custom modifier to add a visible scrollbar
@Composable
fun Modifier.simpleScrollbar(
    scrollState: ScrollState,
    color: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
    width: androidx.compose.ui.unit.Dp = 4.dp
): Modifier = composed {
    // Draw the thumb (bar) based on scroll position
    this.drawWithContent {
        drawContent()  // Draw the actual content first

        val scrollbarOffsetY = (size.height * (scrollState.value / scrollState.maxValue.toFloat())).coerceIn(0f, size.height)
        val scrollbarHeight = (size.height * (size.height / (scrollState.maxValue + size.height).toFloat())).coerceAtLeast(20.dp.toPx())

        // Draw the thumb
        drawRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(size.width - width.toPx(), scrollbarOffsetY),
            size = androidx.compose.ui.geometry.Size(width.toPx(), scrollbarHeight)
        )
    }
        // Optional: Add a background track (faint line)
        .then(
            Modifier
                .padding(end = width)
                .drawWithContent {
                    drawContent()
                    drawRect(
                        color = color.copy(alpha = 0.2f),
                        topLeft = androidx.compose.ui.geometry.Offset(size.width - width.toPx(), 0f),
                        size = androidx.compose.ui.geometry.Size(width.toPx(), size.height)
                    )
                }
        )
}