package com.example.glide.workspace.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.glide.workspace.ui.theme.UiShapeConfigs

enum class ButtonSize { Small, Medium, Large }
enum class ButtonVariant { Filled, Outlined, Tonal }

@Composable
fun ThemedPrimaryButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    text: String = "Default button text",
    enabled: Boolean = true,
    isLoading: Boolean = false,
    variant: ButtonVariant = ButtonVariant.Filled,
    size: ButtonSize = ButtonSize.Medium,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val shape = RoundedCornerShape(UiShapeConfigs.BUTTON_CORNER_RADIUS)

    val height: Dp = when (size) {
        ButtonSize.Small -> 40.dp
        ButtonSize.Medium -> 48.dp
        ButtonSize.Large -> 56.dp
    }

    val horizontalPadding: Dp = when (size) {
        ButtonSize.Small -> 16.dp
        ButtonSize.Medium -> 24.dp
        ButtonSize.Large -> 32.dp
    }

    when (variant) {
        ButtonVariant.Filled -> {
            Button(
                onClick = onClick,
                modifier = modifier
                    .height(height)
                    .fillMaxWidth(),
                enabled = enabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.72f)
                )
            ) {
                ButtonContent(
                    text = text,
                    isLoading = isLoading,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    horizontalPadding = horizontalPadding
                )
            }
        }

        ButtonVariant.Outlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = modifier
                    .height(height)
                    .fillMaxWidth(),
                enabled = enabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    brush = androidx.compose.ui.graphics.SolidColor(
                        if (enabled) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.outline
                    )
                )
            ) {
                ButtonContent(
                    text = text,
                    isLoading = isLoading,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    horizontalPadding = horizontalPadding
                )
            }
        }

        ButtonVariant.Tonal -> {
            Button(
                onClick = onClick,
                modifier = modifier
                    .height(height)
                    .fillMaxWidth(),
                enabled = enabled && !isLoading,
                shape = shape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.12f),
                    disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.38f)
                )
            ) {
                ButtonContent(
                    text = text,
                    isLoading = isLoading,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    horizontalPadding = horizontalPadding
                )
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String,
    isLoading: Boolean,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    horizontalPadding: Dp
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(horizontal = horizontalPadding)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = LocalContentColor.current,
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(8.dp))
        } else {
            leadingIcon?.invoke()
            if (leadingIcon != null) Spacer(Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
            maxLines = 1
        )

        if (!isLoading && trailingIcon != null) {
            Spacer(Modifier.width(8.dp))
            trailingIcon()
        }
    }
}