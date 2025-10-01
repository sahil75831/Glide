package com.example.glide.workspace.auth.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.glide.workspace.core.composables.SquareButton

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Create Community Button
        SquareButton(
            text = "Create Community",
            size = "lg",
            backgroundColor = Color.LightGray,
            textColor = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = {
                navHostController.navigate("create_community")
            }
        )

        // Join Community Button
        SquareButton(
            text = "Join Community",
            size = "lg",
            backgroundColor = Color.Black,
            textColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            onClick = {
                // TODO: Navigate to join community screen later
            }
        )
    }
}
