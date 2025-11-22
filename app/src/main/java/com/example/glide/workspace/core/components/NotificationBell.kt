package com.example.glide.workspace.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.glide.R

@Composable
fun NotificationBell(
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {}
) {
    Image(
        painter = painterResource(id = R.drawable.bell_icon),
        contentDescription = "Notifications",
        modifier = modifier
            .size(28.dp)
            .clickable { onNotificationClick() }
    )
}
