package com.example.glide.workspace.welcome.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.glide.R
import com.example.glide.workspace.ui.theme.Poppins

//@Preview
@Composable
fun Welcome(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.White)
            .fillMaxHeight()
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image takes half the height
            Image(
                painter = painterResource(id = R.drawable.welcome_screen),
                contentDescription = "Welcome Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.5f)
            )

            // Row takes half the height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End   // <-- aligns children to right
                ) {
                    Text(
                        text = "Hello and welcome!",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 40.sp,
                        letterSpacing = 1.5.sp,
                        lineHeight = 32.sp,
                        textAlign = TextAlign.Start,  // <-- text inside also aligns to right
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = "This is your space to\n" +
                                "connect and build\n communities together..",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp,
                        letterSpacing = 1.5.sp,
                        lineHeight = 32.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f)
                            .padding(end = 8.dp)
                    )
                }

            }
        }
    }
}