// workspace/ui/theme/GlideTheme.kt
package com.example.glide.workspace.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.presentation.*


@Composable
fun AppTheme(
    theme: Theme = Theme.Minimalist,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val Typography = Typography()

    val colorScheme = when (theme) {
        Theme.Minimalist -> if (darkTheme) MinimalistDark else MinimalistLight
        Theme.CyberNeon -> if (darkTheme) CyberNeonDark else CyberNeonLight
        Theme.SolarFlare -> if (darkTheme) SolarFlareDark else SolarFlareLight
        Theme.ForestWhisper -> if (darkTheme) ForestWhisperDark else ForestWhisperLight
        Theme.ArcticFrost -> if (darkTheme) ArcticFrostDark else ArcticFrostLight
        Theme.RoyalVelvet -> if (darkTheme) RoyalVelvetDark else RoyalVelvetLight
        Theme.SunsetDunes -> if (darkTheme) SunsetDunesDark else SunsetDunesLight
        Theme.MidnightSapphire -> if (darkTheme) MidnightSapphireDark else MidnightSapphireLight
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}