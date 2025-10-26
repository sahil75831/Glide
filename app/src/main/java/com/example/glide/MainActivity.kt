package com.example.glide

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.workspace.workspace_theme.presentation.TestThemeBox
import com.example.glide.workspace.workspace_theme.presentation.ThemeScreen
import com.example.glide.workspace.workspace_theme.presentation.ThemeViewModel
import com.example.glide.workspace.workspace_theme.presentation.WorkspaceTheme
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

                WorkspaceTheme(currentTheme) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = androidx.compose.material3.MaterialTheme.colorScheme.background
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
//                                .verticalScroll(rememberScrollState())
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.6f)
//                                .verticalScroll(rememberScrollState())
                            ) {
                                ThemeScreen(viewModel = themeViewModel)

                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight(0.4f)
//                                .verticalScroll(rememberScrollState())
                            ) {

                                TestThemeBox()
                            }

                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error in setContent: ${e.message}", e)
        }
    }
}
