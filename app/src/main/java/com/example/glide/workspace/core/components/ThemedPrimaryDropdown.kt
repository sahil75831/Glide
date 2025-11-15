package com.example.glide.workspace.core.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.glide.workspace.ui.theme.ThemesPreview

enum class DropDownVariant {
    Filled, Outline, Tonal
}
enum class DropDownSize {
    Small, Medium, Large
}

@ExperimentalMaterial3Api
@Composable
fun ThemedPrimaryDropdown(
    selectedItem: String,
    items: List<String>,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Default label",
    placeholder: String = "Select an item ..",
    enabled: Boolean = true,
    variant: DropDownVariant = DropDownVariant.Filled,
    size: DropDownSize = DropDownSize.Medium,
    isError: Boolean = false,
    supportingText: String = "Supporting text",
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    var expanded by remember { mutableStateOf(false) }

    // Handle different sizes
    val verticalPadding = when (size) {
        DropDownSize.Small -> 8.dp
        DropDownSize.Medium -> 12.dp
        DropDownSize.Large -> 16.dp
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        when (variant) {
            DropDownVariant.Filled -> {
                TextField(
                    modifier = Modifier.menuAnchor()
                        .fillMaxWidth()
                        .padding(vertical = verticalPadding),
                    value = selectedItem,
                    onValueChange = {},
                    label = { Text(label) },
                    placeholder = { Text(placeholder) },
                    readOnly = true,
                    enabled = enabled,
                    isError = isError,
                    supportingText = {
                        if (supportingText.isNotEmpty()) {
                            Text(supportingText)
                        }
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    interactionSource = interactionSource
                )
            }
            DropDownVariant.Outline -> {
                // TODO: Implement Outline variant
                TextField(
                    modifier = Modifier.menuAnchor()
                        .fillMaxWidth()
                        .padding(vertical = verticalPadding),
                    value = selectedItem,
                    onValueChange = {},
                    label = { Text(label) },
                    placeholder = { Text(placeholder) },
                    readOnly = true,
                    enabled = enabled,
                    isError = isError,
                    supportingText = {
                        if (supportingText.isNotEmpty()) {
                            Text(supportingText)
                        }
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    interactionSource = interactionSource
                )
            }
            DropDownVariant.Tonal -> {
                // TODO: Implement Tonal variant
                TextField(
                    modifier = Modifier.menuAnchor()
                        .fillMaxWidth()
                        .padding(vertical = verticalPadding),
                    value = selectedItem,
                    onValueChange = {},
                    label = { Text(label) },
                    placeholder = { Text(placeholder) },
                    readOnly = true,
                    enabled = enabled,
                    isError = isError,
                    supportingText = {
                        if (supportingText.isNotEmpty()) {
                            Text(supportingText)
                        }
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    interactionSource = interactionSource
                )
            }
        }

        // Move the menu outside of the when statement
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, name = "All Themes - Dropdown")
//@Composable
//fun PreviewThemedPrimaryDropdown() {
//    ThemesPreview {
//        var selectedItem by remember { mutableStateOf("") }
//
//        ThemedPrimaryDropdown(
//            selectedItem = selectedItem,
//            items = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
//            onItemSelected = { selectedItem = it },
//            label = "Choose an option",
//            placeholder = "Select...",
//            supportingText = "Please select one option"
//        )
//    }
//}