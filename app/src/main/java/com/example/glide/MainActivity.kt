package com.example.glide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.glide.workspace.ui.theme.GlideTheme
import com.example.glide.workspace.welcome.presentation.screens.Welcome

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge display
        setContent {
            GlideTheme {
                // Use Surface as the root composable to set the background
                Surface(
                    modifier = Modifier
                        .fillMaxSize() // Ensure it fills the entire available space
                        .background(Color.White),
                ) {
                    // Box to handle content with safe drawing insets
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .safeDrawingPadding() // Adds padding to respect system bars (status, navigation)
                            .background(Color.Transparent) // Your background color
                            .padding(16.dp)
                    ) {
                        // Your content
                        Welcome()
                        val navController = rememberNavController()

                    }
                }
            }
        }
    }
}
