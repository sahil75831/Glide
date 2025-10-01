package com.example.glide.workspace.core.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

data class ButtonConfig(
    val buttonSize: Dp,
    val fontSize: TextUnit,
    val padding: PaddingValues,
    val cornerRadius: Dp
)

@Composable
fun SquareButton(
    modifier: Modifier = Modifier,
    text: String,
    size: String = "md",
    backgroundColor: Color = Color(0x80E6F0FA), // Light blue with transparency for frosted glass effect
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    val config = when (size.lowercase()) {
        "xl" -> ButtonConfig(
            buttonSize = 80.dp,
            fontSize = 20.sp,
            padding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            cornerRadius = 4.dp
        )
        "lg" -> ButtonConfig(
            buttonSize = 64.dp,
            fontSize = 18.sp,
            padding = PaddingValues(horizontal = 14.dp, vertical = 10.dp),
            cornerRadius = 4.dp
        )
        "md" -> ButtonConfig(
            buttonSize = 48.dp,
            fontSize = 16.sp,
            padding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            cornerRadius = 4.dp
        )
        "sm" -> ButtonConfig(
            buttonSize = 40.dp,
            fontSize = 14.sp,
            padding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
            cornerRadius = 4.dp
        )
        "xs" -> ButtonConfig(
            buttonSize = 32.dp,
            fontSize = 12.sp,
            padding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            cornerRadius = 4.dp
        )
        else -> ButtonConfig(
            buttonSize = 48.dp,
            fontSize = 16.sp,
            padding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            cornerRadius = 12.dp
        )
    }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    // Animate background color when pressed
    val animatedBackgroundColor by animateColorAsState(
        targetValue = if (isPressed) backgroundColor.copy(alpha = 0.6f) else backgroundColor,
        animationSpec = tween(durationMillis = 200)
    )

    // Create gradient background to mimic the light blue frosted effect
    val gradient = Brush.linearGradient(
        colors = listOf(
            animatedBackgroundColor,
            animatedBackgroundColor.copy(alpha = 0.9f)
        )
    )

    Box(
        modifier = modifier
            .shadow(
                elevation = if (isPressed) 2.dp else 6.dp,
                shape = RoundedCornerShape(config.cornerRadius),
                ambientColor = Color.LightGray.copy(alpha = 0.3f)
            )
            .clip(RoundedCornerShape(config.cornerRadius))
            .background(gradient)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() }
            .padding(config.padding),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = config.fontSize,
            fontWeight = FontWeight.Bold,
            color = textColor,
            maxLines = 1,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
fun SquareButtonPreview() {
    Column(
        modifier = Modifier.padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SquareButton(
            text = "Button 16",
            size = "xl",
            backgroundColor = Color(0x80E6F0FA), // Light blue with transparency
            textColor = Color.Black,
            onClick = { }
        )
        SquareButton(
            text = "Button 16",
            size = "lg",
            backgroundColor = Color(0x80E6F0FA),
            textColor = Color.Black,
            onClick = { }
        )
        SquareButton(
            text = "Button 16",
            size = "md",
            backgroundColor = Color(0x80E6F0FA),
            textColor = Color.Black,
            onClick = { }
        )
        SquareButton(
            text = "Button 16",
            size = "sm",
            backgroundColor = Color(0x80E6F0FA),
            textColor = Color.Black,
            onClick = { }
        )
        SquareButton(
            text = "Button 16",
            size = "xs",
            backgroundColor = Color(0x80E6F0FA),
            textColor = Color.Black,
            onClick = { }
        )
    }
}