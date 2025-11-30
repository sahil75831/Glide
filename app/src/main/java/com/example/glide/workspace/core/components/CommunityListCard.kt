package com.example.glide.workspace.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glide.R

@Composable
fun CommunityWatermarkCard() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFE9E9E9),
                shape = RoundedCornerShape(28.dp)
            )
            .padding(24.dp)
    ) {

        // --- FULL HEIGHT WATERMARK IMAGE ---
        Image(
            painter = painterResource(id = R.drawable.community_gateway),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()        // fills entire card
                .graphicsLayer {
                    alpha = 0.12f          // watermark visibility
                },
            contentScale = ContentScale.Crop   // fills card uniformly
        )

        // --- FOREGROUND CONTENT ---
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Top row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Mapple Residency | City",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    "Community Admin",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Center text
            Text(
                text = "Hi Emily 👋, your community Design Hub is growing steadily.\n" +
                        "You now have 421 members, with 37 active today.\n" +
                        "Your most active role group is Contributors, and engagement has increased by 12% this week.",
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCommunitySummaryCard() {
    CommunityWatermarkCard()
}



