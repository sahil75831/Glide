package com.example.glide.workspace.community.presentation.screens.community_gateway

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.glide.R
import com.example.glide.workspace.core.components.Separator

@Composable
fun CommunityGateway(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // IMAGE (1/3)
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.community_gateway),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight()
            )
        }

        // TEXT PART (2/3)
        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Text(
                text = buildAnnotatedString {
                    append("Spark a movement.\nBuild your own community\nfrom scratch.\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Your vibe, your tribe")
                    }
                },
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate(route = "create-community")
                    },
            )

            Separator(Modifier.fillMaxWidth())

            Text(
                text = buildAnnotatedString {
                    append("Your new crew is out there.\nFind and join them today.\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("The crew awaits.")
                    }
                },
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            )

            Separator(Modifier.fillMaxWidth())

            Text(
                text = buildAnnotatedString {
                    append("Dive back in. See what your\ncommunities are up to.\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Your shared worlds")
                    }
                },
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
