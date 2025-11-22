package com.example.glide.workspace.core.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TopBarWithAvatar(
    modifier: Modifier = Modifier,
    onSocietyClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth().height(56.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Avatar (Left)
        Avatar(modifier = modifier)

        Spacer(modifier = Modifier.width(8.dp))

        // Society Name (Center)
        TopBarSocietyName(
            modifier = Modifier.weight(1f),
            onSocietyClick = onSocietyClick
        )

        // Notification Bell (Right)
        NotificationBell(
            modifier = Modifier.size(26.dp),
            onNotificationClick = onNotificationClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarWithAvatarPreview() {
    TopBarWithAvatar()
}
