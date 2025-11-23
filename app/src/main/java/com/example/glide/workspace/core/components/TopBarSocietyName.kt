package com.example.glide.workspace.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TopBarSocietyName(
    modifier: Modifier = Modifier,
    onSocietyClick: () -> Unit = {}
) {
    val symbol = "\u2304"


    Column(modifier = modifier.background(Color.Transparent)) {
        Text(
            text = "Rose Dawson",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .clickable { onSocietyClick() }
        )
        Text(
            text = "SJR - Chief admin admin ...",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .clickable { onSocietyClick() }
        )
    }
}
