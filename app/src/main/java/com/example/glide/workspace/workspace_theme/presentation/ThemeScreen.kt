package com.example.glide.workspace.workspace_theme.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.workspace.workspace_theme.domain.models.Theme

@Composable
fun ThemeScreen(
    viewModel: ThemeViewModel = hiltViewModel()
) {
    val currentTheme by viewModel.theme.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Current Theme Header
        Text(
            text = "Current Theme: ${currentTheme.displayName}",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Theme Selection Grid
        Text(
            text = "Select Theme:",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Create rows for all themes
        Theme.entries.forEach { theme ->
            ThemeRow(
                theme = theme,
                isSelected = theme == currentTheme,
                onThemeSelected = { viewModel.changeTheme(theme) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun ThemeRow(
    theme: Theme,
    isSelected: Boolean,
    onThemeSelected: () -> Unit
) {
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
        onClick = onThemeSelected,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(2.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Theme Name
            Text(
                text = theme.displayName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Color preview circles (static palette preview)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ColorCircle(color = getPrimaryColorForTheme(theme))
                ColorCircle(color = getSecondaryColorForTheme(theme))
                ColorCircle(color = getBackgroundColorForTheme(theme))
                ColorCircle(color = getSurfaceColorForTheme(theme))
            }
        }
    }
}

@Composable
fun ColorCircle(color: Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(color)
    )
}

// Static color previews for each theme
fun getPrimaryColorForTheme(theme: Theme): Color {
    return when (theme) {
        Theme.Minimalist -> Color(0xFF6200EE)
        Theme.CyberNeon -> Color(0xFF00FF88)
        Theme.SolarFlare -> Color(0xFFFF6B35)
        Theme.ForestWhisper -> Color(0xFF2E8B57)
        Theme.ArcticFrost -> Color(0xFF87CEEB)
        Theme.RoyalVelvet -> Color(0xFF8A2BE2)
        Theme.SunsetDunes -> Color(0xFFFF8C00)
        Theme.MidnightSapphire -> Color(0xFF191970)
    }
}

fun getSecondaryColorForTheme(theme: Theme): Color {
    return when (theme) {
        Theme.Minimalist -> Color(0xFF03DAC5)
        Theme.CyberNeon -> Color(0xFF00BFFF)
        Theme.SolarFlare -> Color(0xFFFFD700)
        Theme.ForestWhisper -> Color(0xFF90EE90)
        Theme.ArcticFrost -> Color(0xFFE0FFFF)
        Theme.RoyalVelvet -> Color(0xFFDA70D6)
        Theme.SunsetDunes -> Color(0xFFFFD700)
        Theme.MidnightSapphire -> Color(0xFF4169E1)
    }
}

fun getBackgroundColorForTheme(theme: Theme): Color {
    return when (theme) {
        Theme.Minimalist -> Color(0xFFFFFFFF)
        Theme.CyberNeon -> Color(0xFF000000)
        Theme.SolarFlare -> Color(0xFFFFF8DC)
        Theme.ForestWhisper -> Color(0xFFF5F5DC)
        Theme.ArcticFrost -> Color(0xFFF0F8FF)
        Theme.RoyalVelvet -> Color(0xFFF8F8FF)
        Theme.SunsetDunes -> Color(0xFFFFF5EE)
        Theme.MidnightSapphire -> Color(0xFF000080)
    }
}

fun getSurfaceColorForTheme(theme: Theme): Color {
    return when (theme) {
        Theme.Minimalist -> Color(0xFFF5F5F5)
        Theme.CyberNeon -> Color(0xFF1A1A1A)
        Theme.SolarFlare -> Color(0xFFFFE4B5)
        Theme.ForestWhisper -> Color(0xFFDEB887)
        Theme.ArcticFrost -> Color(0xFFB0E0E6)
        Theme.RoyalVelvet -> Color(0xFFD8BFD8)
        Theme.SunsetDunes -> Color(0xFFFFE4C4)
        Theme.MidnightSapphire -> Color(0xFF0000CD)
    }
}



@Composable
fun WorkspaceTheme(
    currentTheme: Theme,
    content: @Composable () -> Unit
) {
    val colorScheme = when (currentTheme) {
        Theme.Minimalist -> lightColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF03DAC5),
            background = Color(0xFFFFFFFF),
            surface = Color(0xFFF5F5F5),
            onBackground = Color.Red,
            onSurface = Color(0xFF000000)
        )

        Theme.CyberNeon -> lightColorScheme(
            primary = Color(0xFF00FF88),
            secondary = Color(0xFF00BFFF),
            background = Color(0xFF000000),
            surface = Color(0xFF1A1A1A),
            onBackground = Color(0xFFFFFFFF),
            onSurface = Color(0xFFFFFFFF)
        )

        Theme.SolarFlare -> lightColorScheme(
            primary = Color(0xFFFF6B35),
            secondary = Color(0xFFFFD700),
            background = Color(0xFFFFF8DC),
            surface = Color(0xFFFFE4B5),
            onBackground = Color(0xFF000000),
            onSurface = Color(0xFF000000)
        )

        Theme.ForestWhisper -> lightColorScheme(
            primary = Color(0xFF2E8B57),
            secondary = Color(0xFF90EE90),
            background = Color(0xFFF5F5DC),
            surface = Color(0xFFDEB887),
            onBackground = Color(0xFF000000),
            onSurface = Color(0xFF000000)
        )

        Theme.ArcticFrost -> lightColorScheme(
            primary = Color(0xFF87CEEB),
            secondary = Color(0xFFE0FFFF),
            background = Color(0xFFF0F8FF),
            surface = Color(0xFFB0E0E6),
            onBackground = Color(0xFF000000),
            onSurface = Color(0xFF000000)
        )

        Theme.RoyalVelvet -> lightColorScheme(
            primary = Color(0xFF8A2BE2),
            secondary = Color(0xFFDA70D6),
            background = Color(0xFFF8F8FF),
            surface = Color(0xFFD8BFD8),
            onBackground = Color(0xFF000000),
            onSurface = Color(0xFF000000)
        )

        Theme.SunsetDunes -> lightColorScheme(
            primary = Color(0xFFFF8C00),
            secondary = Color(0xFFFFD700),
            background = Color(0xFFFFF5EE),
            surface = Color(0xFFFFE4C4),
            onBackground = Color(0xFF000000),
            onSurface = Color(0xFF000000)
        )

        Theme.MidnightSapphire -> lightColorScheme(
            primary = Color(0xFF191970),
            secondary = Color(0xFF4169E1),
            background = Color(0xFF000033),
            surface = Color(0xFF000066),
            onBackground = Color(0xFFFFFFFF),
            onSurface = Color(0xFFFFFFFF)
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}


@Composable
fun TestThemeBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // theme background
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "This is TestThemeBox",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Primary Color Sample",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 18.sp
            )
        }
    }
}
