package com.example.glide.workspace.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.presentation.*


@Composable
fun AppTheme(
    theme: Theme = Theme.Minimalist,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // val Typography = Typography()

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
        typography = AppTypography,
        content = content
    )
}


//## Material Theme Color Scheme Attributes & Usage
//
//### **Primary Colors** (Brand Identity)
//- **primary**: Main brand color for key interactive elements
//- **onPrimary**: Text/icons on primary-colored backgrounds
//- **primaryContainer**: Subtle background for primary-related elements
//- **onPrimaryContainer**: Text/icons on primary container backgrounds
//
//### **Secondary Colors** (Supporting Brand)
//- **secondary**: Secondary brand color for less prominent elements
//- **onSecondary**: Text/icons on secondary-colored backgrounds
//- **secondaryContainer**: Background for secondary interactive elements
//- **onSecondaryContainer**: Text/icons on secondary container backgrounds
//
//### **Tertiary Colors** (Accent/Highlight)
//- **tertiary**: Accent color for highlighting specific content
//- **onTertiary**: Text/icons on tertiary-colored backgrounds
//- **tertiaryContainer**: Background for highlighted content
//- **onTertiaryContainer**: Text/icons on tertiary container backgrounds
//
//### **Surface Colors** (UI Containers)
//- **background**: Main app background color
//- **onBackground**: Primary text/content on background
//- **surface**: Color for cards, sheets, menus
//- **onSurface**: Primary text/content on surfaces
//- **surfaceVariant**: Alternative surface color
//- **onSurfaceVariant**: Secondary/less important text on surfaces
//
//### **Error Colors** (Error States)
//- **error**: Color for error messages and states
//- **onError**: Text/icons on error-colored backgrounds
//- **errorContainer**: Subtle background for error messages
//- **onErrorContainer**: Text/icons on error container backgrounds
//
//### **Border & Outline Colors**
//- **outline**: Main color for borders, dividers, outlines
//- **outlineVariant**: Subtle border color for less prominent dividers
//
//### **Utility Colors**
//- **inverseSurface**: For surfaces that invert typical color roles
//- **inverseOnSurface**: Text/icons on inverse surfaces
//- **inversePrimary**: Primary color when used on inverse surfaces
//- **scrim**: Color for scrims (overlay behind dialogs/sheets)
//- **shadow**: Color for shadows (rarely used directly)
//
//---
//
//## Quick Usage Guide:
//- **Buttons**: Use primary/secondary for container, onPrimary/onSecondary for text
//- **Cards**: Use surface for background, onSurface for text
//- **Text**: Use onBackground for primary, onSurfaceVariant for secondary text
//- **Errors**: Use error for text, errorContainer for backgrounds
//- **Borders**: Use outline for prominent borders, outlineVariant for subtle ones