package com.example.glide.workspace.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.glide.workspace.core.components.ThemedPrimaryInputField
import com.example.glide.workspace.workspace_theme.domain.models.Theme

@Composable
fun ThemesPreview(light:Boolean = true, composable: @Composable () -> Unit) {
    val dark: Boolean = !light
    // List of all themes with names and dark mode flag
    val themePreviews = listOf(
        "Minimalist Light"      to (Theme.Minimalist to light),
        "Minimalist Dark"       to (Theme.Minimalist to dark),
        "Forest Light"          to (Theme.ForestWhisper to light),
        "Forest Dark"           to (Theme.ForestWhisper to dark),
        "Solar Light"           to (Theme.SolarFlare to light),
        "Solar Dark"            to (Theme.SolarFlare to dark),
        "Cyber Light"           to (Theme.CyberNeon to light),
        "Cyber Dark"            to (Theme.CyberNeon to dark),
        "Arctic Light"          to (Theme.ArcticFrost to light),
        "Arctic Dark"           to (Theme.ArcticFrost to dark),
        "Royal Light"           to (Theme.RoyalVelvet to light),
        "Royal Dark"            to (Theme.RoyalVelvet to dark),
        "Sunset Light"          to (Theme.SunsetDunes to light),
        "Sunset Dark"           to (Theme.SunsetDunes to dark),
        "Sapphire Light"        to (Theme.MidnightSapphire to light),
        "Sapphire Dark"         to (Theme.MidnightSapphire to dark)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        themePreviews.forEach { (title, pair) ->
            val (theme, isDark) = pair

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 12.dp)
            )

            AppTheme(theme = theme, darkTheme = !isDark) {
                Surface (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    shadowElevation = 4.dp,
                    tonalElevation = 4.dp
                ) {
                    composable()
                }
            }
        }
    }
}