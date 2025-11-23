package com.example.glide.workspace.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.glide.R




@Composable
fun DimmedPopup(
    onDismiss: () -> Unit = {},
    content: @Composable () -> Unit = { SuccessPopupContent() }
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 1f))
            .clickable(onClick = onDismiss)
    ) {
        Popup (
            alignment = Alignment.Center,
            onDismissRequest = onDismiss
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(24.dp)
            ) {
                content()
            }
        }
    }
}




@Composable
fun SuccessPopupContent(onDismiss: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()) {
        // UI content
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_screen), // Replace with your success image
                contentDescription = "Success Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(120.dp) // Use fixed height instead of fillMaxHeight
                    .fillMaxWidth(0.8f)
            )
            Text(
                text = "Success!",
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Your registration was successful!",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }

        // 🎉 Confetti Layer
        ConfettiLottie()
    }
}
