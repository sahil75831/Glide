package com.example.glide.workspace.community.presentation.screens.roles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.R
import com.example.glide.workspace.community.presentation.viewmodels.CreateNewRoleViewModel
import com.example.glide.workspace.core.components.Accordion
import com.example.glide.workspace.core.components.ButtonVariant
import com.example.glide.workspace.core.components.DropDownVariant
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryDropdown
import com.example.glide.workspace.core.components.ThemedPrimaryInputField
import com.example.glide.workspace.core.components.ThemedPrimaryMultiDropdown

@Composable
fun CreateRole(
    currentCommunityId:String = "",
    modifier: Modifier = Modifier,
    viewModel: CreateNewRoleViewModel = hiltViewModel()
) {
    // Collect states from ViewModel
    val roleName by remember { mutableStateOf(viewModel.roleName) }
    val description by remember { mutableStateOf(viewModel.description) }
    val permissionKeys by remember { mutableStateOf(viewModel.permissionKeys) }
    val isLoading by remember { mutableStateOf(viewModel.isLoading) }
    val errorMessage by remember { mutableStateOf(viewModel.errorMessage) }

    // Or if currentCommunityId might change
    LaunchedEffect(currentCommunityId) {
        if (currentCommunityId.isNotEmpty()) {
            viewModel.setCommunityIdHeader(currentCommunityId)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Fixed Image at top
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.invitee_code),
                contentDescription = "Create role",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
            )
        }

        // Scrollable content below image
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Create New Role",
                    modifier = modifier
                        .fillMaxWidth().padding(bottom = 18.dp),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    lineHeight = 36.sp,
                )

                // Show error message if any
                errorMessage?.let { message ->
                    Text(
                        text = message,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                    )
                }

                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryInputField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        variant = InputFieldVariant.Filled,
                        label = "Role Name",
                        placeHolder = "e.g. Trusty",
                        value = viewModel.roleName,
                        onValueChange = { viewModel.roleName = it },
                        supportingText = "",
                        isError = errorMessage != null && roleName.isBlank()
                    )
                }

                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryInputField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        variant = InputFieldVariant.Filled,
                        label = "Role Description",
                        placeHolder = "e.g. This role can view accounts",
                        value = viewModel.description,
                        onValueChange = { viewModel.description = it },
                        supportingText = "",
                        isError = errorMessage != null && description.isBlank()
                    )
                }

                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryMultiDropdown(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        variant = DropDownVariant.Filled,
                        selectedItems = viewModel.permissionKeys,
                        items = viewModel.allPermissions,
                        onItemSelected = { item ->
                            viewModel.addPermission(item)
                            viewModel.clearError() // Clear error when user interacts
                        },
                        onItemRemoved = { item ->
                            viewModel.removePermission(item)
                        },
                        label = "Permissions Level",
                        placeholder = "Select permission levels..",
                        isError = errorMessage != null && permissionKeys.isEmpty(),
                        supportingText = "",
                        maxDisplayedChips = 3
                    )
                }

                // Optional: Clear All Permissions Button
                if (permissionKeys.isNotEmpty()) {
                    Row(modifier = modifier.padding(horizontal = 8.dp)) {
                        ThemedPrimaryButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            onClick = {
                                viewModel.clearAllPermissions()
                                viewModel.clearError()
                            },
                            enabled = !isLoading,
                            isLoading = false,
                            text = "Clear All Permissions",
                            variant = ButtonVariant.Outlined // You'll need to add this variant to your button component
                        )
                    }
                }

                Row(modifier = modifier.padding(8.dp)) {
                    ThemedPrimaryButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 32.dp),
                        onClick = {
                            viewModel.createCurrentCommunityRole()
                        },
                        enabled = viewModel.isFormValid() && !isLoading,
                        isLoading = isLoading,
                        text = if (isLoading) "Creating..." else "Create Role"
                    )
                }

                // Existing Roles Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Existing Roles & Permissions",
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Accordion()
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}