package com.example.glide.workspace.community.presentation.screens.Join_ExploreCommunity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glide.workspace.core.components.CommunityWatermarkCard


@Composable
fun CommunityList(
    modifier: Modifier = Modifier
) {
    // Fake data for demonstration — Replace with your real list
    val communities = listOf(
        CommunityData(
            name = "Mapple Residency",
            city = "Delhi",
            role = "Community Admin",
            summary = "Hi Emily 👋, your community is growing. You now have 421 members..."
        ),
        CommunityData(
            name = "Tech Square",
            city = "Mumbai",
            role = "Member",
            summary = "Hey Emily 👋, this community is buzzing with 320+ active users..."
        ),
        CommunityData(
            name = "Design Hub",
            city = "Pune",
            role = "Contributor",
            summary = "Hey Emily 👋, engagement is up by 12% and the community is active..."
        )
    )

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Screen Title
        Text(
            text = "Your Communities",
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 12.dp),
            color = MaterialTheme.colorScheme.onSurface
        )

        // Cards List
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(communities.size) { index ->
                val item = communities[index]

                CommunityWatermarkCard(

                )
            }
        }
    }
}


// -------------------- DATA MODEL --------------------
data class CommunityData(
    val name: String,
    val city: String,
    val role: String,
    val summary: String
)


// -------------------- PREVIEW --------------------
@Preview(showBackground = true)
@Composable
fun PreviewCommunityList() {
    CommunityList()
}

