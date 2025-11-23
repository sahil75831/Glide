package com.example.glide.workspace.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec

import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.glide.R


@Composable
fun ConfettiLottie() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.confettie)
    )
    LottieAnimation(
        composition = composition,
        iterations = 3, // LottieConstants.IterateForever,
        modifier = Modifier.fillMaxSize()
    )
}


