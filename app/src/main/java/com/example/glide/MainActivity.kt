package com.example.glide

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.workspace.auth.presentation.screens.RegisterUserScreen
import com.example.glide.workspace.core.components.ThemedPrimaryButton
import com.example.glide.workspace.ui.theme.AppTheme
import com.example.glide.workspace.workspace_theme.presentation.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        try {
            setContent {
                val themeViewModel: ThemeViewModel = hiltViewModel()
                val currentTheme by themeViewModel.theme.collectAsState()

                AppTheme(theme = currentTheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                       Box(
                           modifier = Modifier
                               .fillMaxSize()
                               .background(Color.White)
                               .safeDrawingPadding() // Adds padding to respect system bars (status, navigation)
                               .background(Color.Transparent) // Your background color
                               .padding(16.dp)
                       ){
                           RegisterUserScreen() // Make sure this matches your function name
                       }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error in setContent: ${e.message}", e)
        }
    }
}