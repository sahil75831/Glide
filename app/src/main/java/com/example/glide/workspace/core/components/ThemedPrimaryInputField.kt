package com.example.glide.workspace.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glide.workspace.ui.theme.ThemesPreview
import com.example.glide.workspace.ui.theme.UiShapeConfigs

enum class InputFieldVariant {
    Filled, Outlined, Tonal
}

enum class InputFieldSize {
    Small, Medium, Large
}


@Composable
fun ThemedPrimaryInputField(
    value: String = "Enter the text here...",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    label: String = "Default Label",
    placeHolder: String = "Default placeholder...",
    enabled: Boolean = true,
    variant: InputFieldVariant = InputFieldVariant.Filled,
    size: InputFieldSize = InputFieldSize.Medium,
    isError: Boolean = false,
    supportingText: String = "Default supporting text",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
){
    // Track focus state for border thickness
    val isFocused by interactionSource.collectIsFocusedAsState()
    val rounderCornerShapeValue = UiShapeConfigs.INPUT_CORNER_RADIUS

    val typography = when (size) {
        InputFieldSize.Small -> MaterialTheme.typography.bodySmall.copy(
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.2.sp
        )
        InputFieldSize.Medium -> MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
        InputFieldSize.Large -> MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.5.sp
        )
    }

    Column(modifier = modifier) {
        when(variant) {
            // Filled variant
            InputFieldVariant.Filled -> {
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = if(isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    Column {
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(rounderCornerShapeValue))  // Clips all content
                            .border(
                            width = if (isFocused) 2.dp else 1.dp,
                            color =  when {
                                isError -> MaterialTheme.colorScheme.error
                                isFocused -> MaterialTheme.colorScheme.primary
                                else -> MaterialTheme.colorScheme.outline
                            },
                                shape = RoundedCornerShape(rounderCornerShapeValue) // Clips all content
                        )
                        ){
                            TextField(
                                value = value,
                                onValueChange = onValueChange,
                                modifier = modifier.fillMaxWidth(),
                                enabled = enabled,
                                placeholder = {
                                    Text(
                                        text = placeHolder,
                                        style = typography.copy(
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    )
                                },
                                isError = isError,
                                interactionSource = interactionSource,  // REQUIRED
                                keyboardOptions = keyboardOptions,
                                visualTransformation = visualTransformation,
                                singleLine = singleLine,
                                maxLines = maxLines,
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
                                    errorIndicatorColor = MaterialTheme.colorScheme.error,
                                    cursorColor = MaterialTheme.colorScheme.primary,
                                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                                    unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                                    errorTextColor = MaterialTheme.colorScheme.error,
                                    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                                ),
                            )
                        }
                             // ----- Supporting text (outside the border) -----------------
                             if (supportingText.isNotEmpty()) {
                                 Text(
                                     text = supportingText,
                                     style = MaterialTheme.typography.bodySmall.copy(
                                         color = if (isError) MaterialTheme.colorScheme.error
                                         else MaterialTheme.colorScheme.onSurfaceVariant
                                     ),
                                     modifier = Modifier.padding(top = 4.dp)
                                 )
                             }

                     }

                }

            }

            // Outlined variant
            // ────────────────────── Outlined variant ──────────────────────
            InputFieldVariant.Outlined -> {
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = if (isFocused) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    OutlinedTextField(
                        value = value,
                        onValueChange = onValueChange,
                        modifier = Modifier.fillMaxWidth(),
                        enabled = enabled,
                        placeholder = {
                            Text(
                                text = placeHolder,
                                style = typography.copy(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        },
                        isError = isError,
                        supportingText = if (supportingText.isNotEmpty()) {
                            {
                                Text(
                                    text = supportingText,
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = if (isError) MaterialTheme.colorScheme.error
                                        else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                )
                            }
                        } else null,
                        interactionSource = interactionSource,
                        keyboardOptions = keyboardOptions,
                        visualTransformation = visualTransformation,
                        singleLine = singleLine,
                        maxLines = maxLines,
                        shape = RoundedCornerShape(rounderCornerShapeValue),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            errorBorderColor = MaterialTheme.colorScheme.error,
                            disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.38f),
                            cursorColor = MaterialTheme.colorScheme.primary,
                            focusedTextColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                            errorTextColor = MaterialTheme.colorScheme.error,
                            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                            // Container colors are transparent for true outlined style
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent
                        )
                    )
                }
            }

            // ────────────────────── Tonal variant ──────────────────────
            InputFieldVariant.Tonal -> {
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = if (isFocused) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        )
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(rounderCornerShapeValue))
                            .border(
                                width = if (isFocused) 2.dp else 1.dp,
                                color = when {
                                    isError -> MaterialTheme.colorScheme.error
                                    isFocused -> MaterialTheme.colorScheme.primary
                                    else -> MaterialTheme.colorScheme.outline
                                },
                                shape = RoundedCornerShape(rounderCornerShapeValue)
                            )
                            .background(
                                color = when {
                                    isError -> MaterialTheme.colorScheme.errorContainer
                                    else -> MaterialTheme.colorScheme.surfaceContainerHighest
                                }
                            )
                    ) {
                        TextField(
                            value = value,
                            onValueChange = onValueChange,
                            modifier = Modifier.fillMaxWidth(),
                            enabled = enabled,
                            placeholder = {
                                Text(
                                    text = placeHolder,
                                    style = typography.copy(
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                )
                            },
                            isError = isError,
                            interactionSource = interactionSource,
                            keyboardOptions = keyboardOptions,
                            visualTransformation = visualTransformation,
                            singleLine = singleLine,
                            maxLines = maxLines,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent,
                                cursorColor = MaterialTheme.colorScheme.primary,
                                focusedTextColor = MaterialTheme.colorScheme.onSurface,
                                unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
                                errorTextColor = MaterialTheme.colorScheme.error,
                                disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                            )
                        )
                    }

                    if (supportingText.isNotEmpty()) {
                        Text(
                            text = supportingText,
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = if (isError) MaterialTheme.colorScheme.error
                                else MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
            // Tonal variant --end
        }
    }
}

@Preview(showBackground = true, name = "All Themes - Input Field")
@Composable
fun PreviewInputFields() {
    ThemesPreview {
        ThemedPrimaryInputField(variant = InputFieldVariant.Tonal)
    }
}