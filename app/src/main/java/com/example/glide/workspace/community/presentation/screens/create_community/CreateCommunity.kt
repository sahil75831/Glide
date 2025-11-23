package com.example.glide.workspace.community.presentation.screens.create_community

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
import androidx.navigation.NavHostController
import com.example.glide.R
import com.example.glide.workspace.community.presentation.viewmodels.CreateCommunityViewModel
import com.example.glide.workspace.core.components.DropDownVariant
import com.example.glide.workspace.core.components.InputFieldVariant
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.core.components.ThemedPrimaryDropdown
import com.example.glide.workspace.core.components.ThemedPrimaryInputField

@Composable
fun CreateCommunity (
    navController: NavHostController,
    viewModel: CreateCommunityViewModel = hiltViewModel(),
    onSuccess: ()->Unit = {},
    onBack: ()->Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxSize()) {
        Column {
            Text(
                text = "Create community",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Hi, be an owner of your own community",
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = painterResource(id = R.drawable.create_community),
                contentDescription = "Login Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .fillMaxHeight(0.3f)
                    .align(Alignment.CenterHorizontally),
            )

        }

        // content area -- main body
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
                .verticalScroll(scrollState)
        ) {

            // Community Name
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Community Name",
                    placeHolder = "e.g., Walnut Residency",
                    value = viewModel.name,
                    onValueChange = { viewModel.name = it },
                    supportingText = ""
                )
            }

            // Community Address
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Community Address",
                    placeHolder = "e.g., Chocolate Land, House 1HF",
                    value = viewModel.address,
                    onValueChange = { viewModel.address = it },
                    supportingText = ""
                )
            }

            // City
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "City",
                    placeHolder = "e.g., Mumbai",
                    value = viewModel.city,
                    onValueChange = { viewModel.city = it },
                    supportingText = ""
                )
            }

            // State
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "State",
                    placeHolder = "e.g., Maharashtra",
                    value = viewModel.state,
                    onValueChange = { viewModel.state = it },
                    supportingText = ""
                )
            }

            // Pincode
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Pincode",
                    placeHolder = "e.g., 400001",
                    value = viewModel.pincode,
                    onValueChange = { viewModel.pincode = it },
                    supportingText = ""
                )
            }

            // Country
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Country",
                    placeHolder = "e.g., India",
                    value = viewModel.country,
                    onValueChange = { viewModel.country = it },
                    supportingText = ""
                )
            }

            // Community Description
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryInputField(
                    variant = InputFieldVariant.Filled,
                    label = "Community Description",
                    placeHolder = "Describe your community",
                    value = viewModel.description,
                    onValueChange = { viewModel.description = it },
                    supportingText = ""
                )
            }

            // Type Dropdown (TODO)
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryDropdown(
                    variant = DropDownVariant.Filled,
                    selectedItem = viewModel.type,
                    items = listOf("Appartment", "villa", "colony").map { it.toString() },
                    onItemSelected = {viewModel.type = it},
                    label = "Type",
                    placeholder = "Select the community type..",
                )
            }

            // Type Dropdown (TODO)
            Row(modifier = Modifier.padding(8.dp)) {
                ThemedPrimaryButton(
                    onClick = {viewModel.createCommunity()},
                    enabled = if (
                        viewModel.name.isNotBlank()
                        && viewModel.address.isNotBlank()
                        && viewModel.city.isNotBlank()
                        && viewModel.country.isNotBlank()
                        && viewModel.state.isNotBlank()
                        && viewModel.type.isNotBlank()
                        ) {
                        true
                    } else false,
                    isLoading = viewModel.isLoading,
                    text = "Create"
                )
            }
            // Error Message
            viewModel.errorMessage?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium)
            }

            // Success → Navigate
            LaunchedEffect (viewModel.createCommunityResult) {
                viewModel.createCommunityResult?.let { result ->
                    if (result.success) {
                        onSuccess()
                    }
                }
            }
        }

    }

}