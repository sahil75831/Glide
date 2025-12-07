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
    onBackClick: () -> Unit = {},
    onGridClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth().height(56.dp)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Avatar(modifier = modifier)

        Spacer(modifier = Modifier.width(8.dp))

        TopBarSocietyName(
            modifier = Modifier.weight(1f),
            onSocietyClick = {}
        )

        Spacer(modifier = Modifier.width(8.dp))

        BackArrow(
            modifier = Modifier.size(26.dp),
            onNotificationClick = onBackClick
        )

        Spacer(modifier = Modifier.width(8.dp))

        AppGrid(
            modifier = Modifier.size(26.dp),
            onNotificationClick = onGridClick
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopBarWithAvatarPreview() {
    TopBarWithAvatar()
}
