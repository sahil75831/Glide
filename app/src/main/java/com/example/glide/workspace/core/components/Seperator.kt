package com.example.glide.workspace.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Separator(
    modifier: Modifier = Modifier,
    text: String = "OR",
    lineColor: Color = MaterialTheme.colorScheme.secondary,
    textColor: Color = MaterialTheme.colorScheme.primary
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = lineColor,
            thickness = 1.dp
        )

        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = textColor,
            style = MaterialTheme.typography.labelMedium
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = lineColor,
            thickness = 1.dp
        )
    }
}
