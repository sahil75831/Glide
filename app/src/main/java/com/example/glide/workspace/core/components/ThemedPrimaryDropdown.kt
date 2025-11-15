// core/components/ThemedPrimaryDropdown.kt
package com.example.glide.workspace.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.glide.workspace.ui.theme.UiShapeConfigs

enum class DropDownVariant { Filled, Outlined, Tonal }
enum class DropDownSize { Small, Medium, Large }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemedPrimaryDropdown(
    selectedItem: String,
    items: List<String>,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Select",
    placeholder: String = "Choose an option",
    enabled: Boolean = true,
    variant: DropDownVariant = DropDownVariant.Filled,
    size: DropDownSize = DropDownSize.Medium,
    isError: Boolean = false,
    supportingText: String = "",
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    var expanded by remember { mutableStateOf(false) }
    val isFocused by interactionSource.collectIsFocusedAsState()

    // Match input field corner radius
    val cornerRadius = UiShapeConfigs.INPUT_CORNER_RADIUS
    val dropDownMenuRadius = UiShapeConfigs.DROP_DOWN_MENU_CORNER_RADIUS

    // Size-based padding
    val verticalPadding = when (size) {
        DropDownSize.Small -> 8.dp
        DropDownSize.Medium -> 12.dp
        DropDownSize.Large -> 16.dp
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (enabled) expanded = !expanded },
        modifier = modifier
    ) {
        // === TEXT FIELD (Anchor) ===
        when (variant) {
            DropDownVariant.Filled -> {
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = if(isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    TextField(
                        modifier = Modifier
                            .clip(RoundedCornerShape(cornerRadius))
                            .menuAnchor()
                            .fillMaxWidth(),
                        value = selectedItem,
                        onValueChange = {},
                        readOnly = true,
//                    label = { Text(label) },
                        placeholder = { Text(placeholder) },
                        enabled = enabled,
                        isError = isError,
                        supportingText = supportingText.takeIf { it.isNotEmpty() }?.let { { Text(it) } },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        shape = RoundedCornerShape(cornerRadius),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                            errorContainerColor = MaterialTheme.colorScheme.errorContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                            unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
                            errorIndicatorColor = MaterialTheme.colorScheme.error,
                            cursorColor = MaterialTheme.colorScheme.primary,
                            focusedTextColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                            errorTextColor = MaterialTheme.colorScheme.error
                        ),
                        interactionSource = interactionSource
                    )
                }

            }

            DropDownVariant.Outlined -> {   }

            DropDownVariant.Tonal -> {  }
        }

        // === DROPDOWN MENU (Matches TextField Width + Theme) ===
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .exposedDropdownSize() // This makes it match the TextField width
                .background(
                    color = MaterialTheme.colorScheme.surface ,
                    // shape = RoundedCornerShape(dropDownMenuRadius)
                )
                .heightIn(max = 200.dp)
                .border(
                    width = 1.dp,
                    color = if (isError) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.outline,
                    // shape = RoundedCornerShape(dropDownMenuRadius)
                ),
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                )
            }
        }
    }
}