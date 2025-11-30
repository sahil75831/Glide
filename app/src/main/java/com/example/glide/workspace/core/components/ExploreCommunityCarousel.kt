package com.example.glide.workspace.core.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glide.R
import com.example.glide.workspace.community.domain.models.CommunityMembership


@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun ExploreCommunityCarousel(
    modifier: Modifier = Modifier,
    communities: List<CommunityMembership> = emptyList()
    ) {
    data class CarouselItem(
        val id: String,
        @DrawableRes val imageResId: Int,
        val title: String,
        val city: String,
        val description: String,
        val role: String
    )


    val carouselItems = if (communities.isNotEmpty()){
        communities.map {
            communityMembership -> CarouselItem(
                id = communityMembership.membershipId,
                imageResId = R.drawable.explore_community_card,
                title = communityMembership.community.name,
                city = communityMembership.community.city,
                description = "tag line of community",
                role = communityMembership.role.name
            )
        }
    }else{
        listOf(
            CarouselItem(
                id = "null",
                imageResId = R.drawable.explore_community_card,
                title = "No communities",
                city = "City",
                description = "Join a community to see them here",
                role = "Member"

            )
        )
    }

    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { carouselItems.count() },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 16.dp, bottom = 16.dp),
        preferredItemWidth = 320.dp,
        itemSpacing = 12.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { i ->
        val item = carouselItems[i]
        Card(
            modifier = Modifier.padding(6.dp)
                .width(320.dp)
                .height(120.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Image on the left
                androidx.compose.foundation.Image(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Transparent, RoundedCornerShape(12.dp)),
                    painter = painterResource(id = item.imageResId),
                    contentDescription = item.description,
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )

                // Text content on the right
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    // Title and City in one line
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item.city,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    // Description with proper constraints
                    Text(
                        text = item.description,
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        lineHeight = 18.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewExploreCarouselExample() {
    MaterialTheme {
        ExploreCommunityCarousel()
    }
}