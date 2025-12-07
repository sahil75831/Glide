package com.example.glide.workspace.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.glide.workspace.ui.theme.UiShapeConfigs



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemedPrimaryMultiDropdown(
    selectedItems: List<String>,
    items: List<String>,
    onItemSelected: (String) -> Unit,
    onItemRemoved: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Select",
    placeholder: String = "Choose options",
    enabled: Boolean = true,
    variant: DropDownVariant = DropDownVariant.Filled,
    size: DropDownSize = DropDownSize.Medium,
    isError: Boolean = false,
    supportingText: String = "",
    maxDisplayedChips: Int = 3,
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

    // Height based on size
    val minHeight = when (size) {
        DropDownSize.Small -> 40.dp
        DropDownSize.Medium -> 56.dp
        DropDownSize.Large -> 64.dp
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { if (enabled) expanded = !expanded },
        modifier = modifier
    ) {
        // === TEXT FIELD (Anchor) ===
        Column {
            // Label
            if (label.isNotEmpty()) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = when {
                            !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                            isError -> MaterialTheme.colorScheme.error
                            isFocused -> MaterialTheme.colorScheme.primary
                            else -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        }
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Box(
                modifier = Modifier
//                    .clip(RoundedCornerShape(cornerRadius))
                    .menuAnchor()
                    .fillMaxWidth()
            ) {
                // Background based on variant
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(
                            color = when {
                                !enabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                                isError -> MaterialTheme.colorScheme.errorContainer
                                variant == DropDownVariant.Filled && !isFocused ->
                                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                                else -> MaterialTheme.colorScheme.surface
                            },
//                            shape = RoundedCornerShape(cornerRadius)
                        )
                        .border(
                            width = if (variant == DropDownVariant.Outlined || isFocused || isError) 1.dp else 0.dp,
                            color = when {
                                isError -> MaterialTheme.colorScheme.error
                                isFocused -> MaterialTheme.colorScheme.primary
                                variant == DropDownVariant.Outlined -> MaterialTheme.colorScheme.outline
                                else -> MaterialTheme.colorScheme.surface
                            },
//                            shape = RoundedCornerShape(cornerRadius)
                        )
                )

                // Content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = verticalPadding
                        )
                ) {
                    // Selected items as chips
                    if (selectedItems.isNotEmpty()) {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = if (selectedItems.isNotEmpty()) 8.dp else 0.dp)
                        ) {
                            // Display only a limited number of chips, show count for rest
                            if (selectedItems.size <= maxDisplayedChips) {
                                items(selectedItems) { item ->
                                    SelectedItemChip(
                                        item = item,
                                        onRemove = onItemRemoved,
                                        enabled = enabled
                                    )
                                }
                            } else {
                                // Show first (maxDisplayedChips - 1) items and a count chip
                                items(selectedItems.take(maxDisplayedChips - 1)) { item ->
                                    SelectedItemChip(
                                        item = item,
                                        onRemove = onItemRemoved,
                                        enabled = enabled
                                    )
                                }
                                item {
                                    AssistChip(
                                        onClick = {},
                                        label = {
                                            Text(
                                                text = "+${selectedItems.size - (maxDisplayedChips - 1)} more",
                                                style = MaterialTheme.typography.labelSmall
                                            )
                                        },
                                        shape = RoundedCornerShape(8.dp),
                                        enabled = false,
                                        colors = AssistChipDefaults.assistChipColors(
                                            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                                        )
                                    )
                                }
                            }
                        }
                    }

                    // Placeholder or value text
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (selectedItems.isEmpty()) placeholder
                            else if (selectedItems.size == 1) "1 item selected"
                            else "${selectedItems.size} items selected",
                            style = MaterialTheme.typography.bodyMedium,
                            color = when {
                                !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                selectedItems.isEmpty() -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                                else -> MaterialTheme.colorScheme.onSurface
                            },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )

                        // Dropdown icon
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }

            // Supporting text
            if (supportingText.isNotEmpty()) {
                Text(
                    text = supportingText,
                    style = MaterialTheme.typography.bodySmall,
                    color = when {
                        isError -> MaterialTheme.colorScheme.error
                        !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    modifier = Modifier.padding(top = 4.dp, start = 16.dp)
                )
            }
        }

        // === DROPDOWN MENU ===
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .exposedDropdownSize()
                .background(
                    color = MaterialTheme.colorScheme.surface,
//                    shape = RoundedCornerShape(dropDownMenuRadius)
                )
                .heightIn(max = 200.dp)
                .border(
                    width = 1.dp,
                    color = if (isError) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.outline,
//                    shape = RoundedCornerShape(dropDownMenuRadius)
                )
        ) {
            items.forEach { item ->
                val isSelected = selectedItems.contains(item)

                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Checkbox for selection
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = {
                                    if (isSelected) {
                                        onItemRemoved(item)
                                    } else {
                                        onItemSelected(item)
                                    }
                                },
                                enabled = enabled,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = item,
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (enabled) MaterialTheme.colorScheme.onSurface
                                else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    },
                    onClick = {
                        if (enabled) {
                            if (isSelected) {
                                onItemRemoved(item)
                            } else {
                                onItemSelected(item)
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    enabled = enabled
                )
            }
        }
    }
}

@Composable
private fun SelectedItemChip(
    item: String,
    onRemove: (String) -> Unit,
    enabled: Boolean
) {
    AssistChip(
        onClick = { if (enabled) onRemove(item) },
        label = {
            Text(
                text = item,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        shape = RoundedCornerShape(8.dp),
        colors = AssistChipDefaults.assistChipColors(
            leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledLeadingIconContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Remove $item",
                modifier = Modifier.size(16.dp)
            )
        },
        enabled = enabled
    )
}