package com.example.glide.workspace.workspace_theme.presentation

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Minimalist (Default)
// Minimalist Black & White Light Theme
val MinimalistLight = lightColorScheme(
    // Primary Colors - Charcoal Black
    primary = Color(0xFF000000),        // Black
    onPrimary = Color(0xFFFFFFFF),      // Pure white
    primaryContainer = Color(0xFFF7FAFC), // Almost white
    onPrimaryContainer = Color(0xFF1A202C), // Dark charcoal

    // Secondary Colors - Medium Grays
    secondary = Color(0xFF4A5568),      // Slate gray
    onSecondary = Color(0xFFFFFFFF),    // White
    secondaryContainer = Color(0xFFEDF2F7), // Light gray
    onSecondaryContainer = Color(0xFF2D3748), // Charcoal

    // Tertiary Colors - Accent Gray
    tertiary = Color(0xFF718096),       // Cool gray accent
    onTertiary = Color(0xFFFFFFFF),     // White
    tertiaryContainer = Color(0xFFE2E8F0), // Light gray
    onTertiaryContainer = Color(0xFF4A5568), // Slate gray

    // Background & Surface - Clean Whites & Grays
    background = Color(0xFFFFFFFF),     // Pure white
    onBackground = Color(0xFF1A202C),   // Near black
    surface = Color(0xFFFFFFFF),        // Pure white
    onSurface = Color(0xFF1A202C),      // Near black
    surfaceVariant = Color(0xFFF7FAFC), // Off-white
    onSurfaceVariant = Color(0xFF718096), // Medium gray

    // Error Colors - Retained for functionality
    error = Color(0xFFE53E3E),          // Clean red
    onError = Color(0xFFFFFFFF),        // White
    errorContainer = Color(0xFFFFF5F5), // Very light red
    onErrorContainer = Color(0xFFC53030), // Dark red

    // Outline Colors - Subtle borders
    outline = Color(0xFFE2E8F0),        // Light gray border
    outlineVariant = Color(0xFFEDF2F7), // Very light gray border

    // Inverse Colors
    inverseSurface = Color(0xFF1A202C), // Dark for inverse
    inverseOnSurface = Color(0xFFFFFFFF), // White on inverse
    inversePrimary = Color(0xFFCBD5E0), // Light gray inverse

    // Utility Colors
    scrim = Color(0x991A202C),          // Semi-transparent dark
//    shadow = Color(0x1A000000)          // Subtle shadow
)

// Minimalist Black & White Dark Theme
val MinimalistDark = darkColorScheme(
    // Primary Colors - Clean White
    primary = Color(0xFFFFFFFF),        // Pure white
    onPrimary = Color(0xFF000000),      // Pure black
    primaryContainer = Color(0xFF1A202C), // Dark charcoal
    onPrimaryContainer = Color(0xFFE2E8F0), // Light gray

    // Secondary Colors - Medium Grays
    secondary = Color(0xFFCBD5E0),      // Light gray
    onSecondary = Color(0xFF000000),    // Black
    secondaryContainer = Color(0xFF2D3748), // Medium dark
    onSecondaryContainer = Color(0xFFE2E8F0), // Light gray

    // Tertiary Colors - Accent Gray
    tertiary = Color(0xFFA0AEC0),       // Medium light gray
    onTertiary = Color(0xFF000000),     // Black
    tertiaryContainer = Color(0xFF4A5568), // Medium gray
    onTertiaryContainer = Color(0xFFEDF2F7), // Off-white

    // Background & Surface - Dark Grays
    background = Color(0xFF0F1419),     // Deep dark
    onBackground = Color(0xFFE2E8F0),   // Light gray text
    surface = Color(0xFF1A202C),        // Dark charcoal
    onSurface = Color(0xFFE2E8F0),      // Light gray text
    surfaceVariant = Color(0xFF2D3748), // Medium dark
    onSurfaceVariant = Color(0xFFA0AEC0), // Medium gray text

    // Error Colors
    error = Color(0xFFFC8181),          // Light red
    onError = Color(0xFF000000),        // Black
    errorContainer = Color(0xFF742A2A), // Dark red
    onErrorContainer = Color(0xFFFED7D7), // Light red

    // Outline Colors
    outline = Color(0xFF4A5568),        // Medium gray border
    outlineVariant = Color(0xFF2D3748), // Dark gray border

    // Inverse Colors
    inverseSurface = Color(0xFFE2E8F0), // Light for inverse
    inverseOnSurface = Color(0xFF1A202C), // Dark on inverse
    inversePrimary = Color(0xFF2D3748), // Charcoal inverse

    // Utility Colors
    scrim = Color(0x99000000),          // Semi-transparent black
//    shadow = Color(0xFF000000)          // Black shadow
)

// CyberNeon
val CyberNeonLight = lightColorScheme(
    // ── Primary (Electric Cyan) ─────────────────────
    primary               = Color(0xFF00FFEA), // Neon cyan
    onPrimary             = Color(0xFF000000), // Black
    primaryContainer      = Color(0xFFB2FFFF), // Pale cyan
    onPrimaryContainer    = Color(0xFF006064), // Deep teal

    // ── Secondary (Neon Magenta) ───────────────────
    secondary             = Color(0xFFFF00E6), // Neon magenta
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFFFB2FF), // Light magenta
    onSecondaryContainer  = Color(0xFF6A1B9A), // Deep purple

    // ── Tertiary (Spring Green) ───────────────────
    tertiary              = Color(0xFF00FF7F), // Spring green
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFFB2FFB2), // Pale mint
    onTertiaryContainer   = Color(0xFF1B5E20), // Dark green

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFFFFFFF), // Pure white
    onBackground          = Color(0xFF000000), // Black
    surface               = Color(0xFFFFFFFF),
    onSurface             = Color(0xFF000000),
    surfaceVariant        = Color(0xFFF0F0F5), // Very light gray
    onSurfaceVariant      = Color(0xFF555566), // Mid gray

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF1744), // Neon red
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFD1D1),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF00E5FF), // Cyan glow border
    outlineVariant        = Color(0xFFB2FFFF),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF0A0A12), // Near-black
    inverseOnSurface      = Color(0xFFE0E0E0),
    inversePrimary        = Color(0xFF00BFA5), // Deep cyan

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)  // Semi-transparent black
)

val CyberNeonDark = darkColorScheme(
    // ── Primary (Electric Cyan) ─────────────────────
    primary               = Color(0xFF00FFEA), // Same neon cyan
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFF006064), // Deep teal
    onPrimaryContainer    = Color(0xFFB2FFFF),

    // ── Secondary (Neon Magenta) ───────────────────
    secondary             = Color(0xFFFF00E6),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFF6A1B9A), // Deep purple
    onSecondaryContainer  = Color(0xFFFFB2FF),

    // ── Tertiary (Spring Green) ───────────────────
    tertiary              = Color(0xFF00FF7F),
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFF1B5E20), // Dark green
    onTertiaryContainer   = Color(0xFFB2FFB2),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF0A0A12), // Deep void
    onBackground          = Color(0xFFE0E0E0), // Light gray
    surface               = Color(0xFF11111B), // Slightly raised
    onSurface             = Color(0xFFE0E0E0),
    surfaceVariant        = Color(0xFF1E1E2E), // Darker variant
    onSurfaceVariant      = Color(0xFF00E5FF),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF3E5E), // Bright red
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF00E5FF),
    outlineVariant        = Color(0xFF00BFA5),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFFFFFFF),
    inverseOnSurface      = Color(0xFF000000),
    inversePrimary        = Color(0xFF00BFA5),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)
)

// SolarFlare
val SolarFlareLight = lightColorScheme(
    // ── Primary ─────────────────────────────────────
    primary               = Color(0xFFFF6B35), // Bright solar orange
    onPrimary             = Color(0xFFFFFFFF), // White
    primaryContainer      = Color(0xFFFFE0B2), // Light peach
    onPrimaryContainer    = Color(0xFFB71C1C), // Deep ember

    // ── Secondary ───────────────────────────────────
    secondary             = Color(0xFFFFD166), // Golden sun
    onSecondary           = Color(0xFF000000), // Black
    secondaryContainer    = Color(0xFFFFF3E0), // Creamy light gold
    onSecondaryContainer  = Color(0xFF8B4513), // Rich bronze

    // ── Tertiary ───────────────────────────────────
    tertiary              = Color(0xFFFF4B6B), // Hot coral pink
    onTertiary            = Color(0xFFFFFFFF), // White
    tertiaryContainer     = Color(0xFFFFC1CC), // Soft rose
    onTertiaryContainer   = Color(0xFFC2185B), // Deep magenta

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFFFFBFA), // Warm off-white
    onBackground          = Color(0xFF2D1B00), // Deep umber
    surface               = Color(0xFFFFFFFF), // Pure white
    onSurface             = Color(0xFF2D1B00),
    surfaceVariant        = Color(0xFFFFF0E6), // Very light peach
    onSurfaceVariant      = Color(0xFF8B4513), // Bronze text

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F), // Classic red
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFFFB74D), // Soft orange border
    outlineVariant        = Color(0xFFFFE0B2), // Lighter peach border

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF2D1B00), // Deep umber for inverse
    inverseOnSurface      = Color(0xFFFFFFFF),
    inversePrimary        = Color(0xFFFF8A65), // Warm coral inverse

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x992D1B00)  // Semi-transparent deep orange
    // shadow              = Color(0x1A000000)
)

val SolarFlareDark = darkColorScheme(
    // ── Primary ─────────────────────────────────────
    primary               = Color(0xFFFF8A65), // Warm coral
    onPrimary             = Color(0xFF000000), // Black
    primaryContainer      = Color(0xFFE65100), // Deep orange
    onPrimaryContainer    = Color(0xFFFFE0B2), // Light peach

    // ── Secondary ───────────────────────────────────
    secondary             = Color(0xFFFFE082), // Bright gold
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFFFB74D), // Rich amber
    onSecondaryContainer  = Color(0xFFFFF3E0),

    // ── Tertiary ───────────────────────────────────
    tertiary              = Color(0xFFFF8A99), // Hot pink
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFFC2185B), // Deep magenta
    onTertiaryContainer   = Color(0xFFFFC1CC),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF2D1B2E), // Deep purple-brown night
    onBackground          = Color(0xFFFFF3E0), // Creamy light
    surface               = Color(0xFF3A1F22), // Dark warm surface
    onSurface             = Color(0xFFFFF3E0),
    surfaceVariant        = Color(0xFF4A2A2D), // Darker variant
    onSurfaceVariant      = Color(0xFFFFB74D),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252), // Bright warning red
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFFFB74D), // Amber border
    outlineVariant        = Color(0xFFFF8A65), // Coral border

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFFFF3E0), // Creamy light for inverse
    inverseOnSurface      = Color(0xFF2D1B00),
    inversePrimary        = Color(0xFFE65100),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)  // Semi-transparent black
    // shadow              = Color(0xFF000000)
)

// ForestWhisper
val ForestWhisperLight = lightColorScheme(
    // ── Primary ─────────────────────────────────────
    primary               = Color(0xFF2E8B57), // Deep forest
    onPrimary             = Color(0xFFFFFFFF), // White
    primaryContainer      = Color(0xFFC8E6C9), // Very light mint
    onPrimaryContainer    = Color(0xFF1B5E20), // Darker forest

    // ── Secondary ───────────────────────────────────
    secondary             = Color(0xFF8FBC8F), // Moss
    onSecondary           = Color(0xFF000000), // Black
    secondaryContainer    = Color(0xFFDFF0D8), // Pale moss
    onSecondaryContainer  = Color(0xFF336633), // Deep moss

    // ── Tertiary ───────────────────────────────────
    tertiary              = Color(0xFFA0522D), // Cedar brown
    onTertiary            = Color(0xFFFFFFFF), // White
    tertiaryContainer     = Color(0xFFDAB28A), // Light cedar
    onTertiaryContainer   = Color(0xFF5D2F10), // Dark cedar

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFF8FFF8), // Almost-white with a green tint
    onBackground          = Color(0xFF1B2E1B), // Deep forest text
    surface               = Color(0xFFFFFFFF), // Pure white
    onSurface             = Color(0xFF1B2E1B), // Same as onBackground
    surfaceVariant        = Color(0xFFE8F5E9), // Very light mint-gray
    onSurfaceVariant      = Color(0xFF557755), // Mid-forest

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F), // Classic red (kept for accessibility)
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFA5D6A7), // Soft sage border
    outlineVariant        = Color(0xFFC8E6C9), // Lighter sage

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF1B2E1B), // Dark forest for inverse cards
    inverseOnSurface      = Color(0xFFFFFFFF),
    inversePrimary        = Color(0xFF81C784), // Light leaf inverse

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x991B2E1B)  // Semi-transparent forest
    // shadow              = Color(0x1A000000) // optional subtle shadow
)

val ForestWhisperDark = darkColorScheme(
    // ── Primary ─────────────────────────────────────
    primary               = Color(0xFF66BB6A), // Bright leaf
    onPrimary             = Color(0xFF000000), // Black
    primaryContainer      = Color(0xFF2E7D32), // Darker leaf
    onPrimaryContainer    = Color(0xFFC8E6C9), // Light mint

    // ── Secondary ───────────────────────────────────
    secondary             = Color(0xFFA5D6A7), // Light sage
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFF558B2F), // Deep sage
    onSecondaryContainer  = Color(0xFFDFF0D8),

    // ── Tertiary ───────────────────────────────────
    tertiary              = Color(0xFFBCAAA4), // Muted tan
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFF8D6E63), // Darker tan
    onTertiaryContainer   = Color(0xFFFFD7B5),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF121F15), // Deep forest night
    onBackground          = Color(0xFFE8F5E8), // Light mint text
    surface               = Color(0xFF1A2E1B), // Slightly lighter surface
    onSurface             = Color(0xFFE8F5E8),
    surfaceVariant        = Color(0xFF2E3B2F), // Darker variant
    onSurfaceVariant      = Color(0xFFA5D6A7),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252), // Light red for visibility
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF66BB6A), // Bright leaf border
    outlineVariant        = Color(0xFF4CAF50), // Slightly darker leaf

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFE8F5E8), // Light mint for inverse
    inverseOnSurface      = Color(0xFF1B2E1B),
    inversePrimary        = Color(0xFF2E7D32),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)  // Semi-transparent black
    // shadow              = Color(0xFF000000)
)

// ArcticFrost
val ArcticFrostLight = lightColorScheme(
    // ── Primary (Sky Blue) ──────────────────────────
    primary               = Color(0xFF4FC3F7), // Light sky blue
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFFB3E5FC), // Pale blue
    onPrimaryContainer    = Color(0xFF01579B), // Deep blue

    // ── Secondary (Light Cyan) ─────────────────────
    secondary             = Color(0xFF81D4FA),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFE1F5FE), // Very light cyan
    onSecondaryContainer  = Color(0xFF0277BD),

    // ── Tertiary (Deep Ocean) ─────────────────────
    tertiary              = Color(0xFF0288D1), // Strong blue
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFF81D4FA),
    onTertiaryContainer   = Color(0xFF0D47A1),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFF8FDFF), // Snow white
    onBackground          = Color(0xFF0A1E29), // Deep navy
    surface               = Color(0xFFFFFFFF),
    onSurface             = Color(0xFF0A1E29),
    surfaceVariant        = Color(0xFFE3F2FD), // Light ice
    onSurfaceVariant      = Color(0xFF2962FF),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F),
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF81D4FA),
    outlineVariant        = Color(0xFFB3E5FC),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF0A1E29),
    inverseOnSurface      = Color(0xFFE1F5FE),
    inversePrimary        = Color(0xFF0277BD),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x990A1E29)
)

val ArcticFrostDark = darkColorScheme(
    // ── Primary (Light Sky Blue) ───────────────────
    primary               = Color(0xFF4FC3F7),
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFF01579B),
    onPrimaryContainer    = Color(0xFFB3E5FC),

    // ── Secondary (Soft Cyan) ─────────────────────
    secondary             = Color(0xFFB3E5FC),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFF0277BD),
    onSecondaryContainer  = Color(0xFFE1F5FE),

    // ── Tertiary (Bright Blue) ───────────────────
    tertiary              = Color(0xFF29B6F6),
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFF0D47A1),
    onTertiaryContainer   = Color(0xFF81D4FA),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF0A1E29), // Deep arctic night
    onBackground          = Color(0xFFE1F5FE), // Icy light text
    surface               = Color(0xFF112E3C), // Raised frost
    onSurface             = Color(0xFFE1F5FE),
    surfaceVariant        = Color(0xFF1C3A4D),
    onSurfaceVariant      = Color(0xFF81D4FA),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252),
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF4FC3F7),
    outlineVariant        = Color(0xFF29B6F6),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFF8FDFF),
    inverseOnSurface      = Color(0xFF0A1E29),
    inversePrimary        = Color(0xFF0277BD),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)
)

// RoyalVelvet
val RoyalVelvetLight = lightColorScheme(
    // ── Primary (Deep Amethyst) ─────────────────────
    primary               = Color(0xFF7E57C2), // Royal purple
    onPrimary             = Color(0xFFFFFFFF),
    primaryContainer      = Color(0xFFD1C4E4), // Light lavender
    onPrimaryContainer    = Color(0xFF4A148C), // Deep indigo

    // ── Secondary (Vivid Magenta) ───────────────────
    secondary             = Color(0xFFAB47BC),
    onSecondary           = Color(0xFFFFFFFF),
    secondaryContainer    = Color(0xFFE1BEE7),
    onSecondaryContainer  = Color(0xFF6A1B9A),

    // ── Tertiary (Indigo) ───────────────────────────
    tertiary              = Color(0xFF5E35B1),
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFFB39DDB),
    onTertiaryContainer   = Color(0xFF311B92),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFF5F3FF), // Soft violet white
    onBackground          = Color(0xFF1A0D2E), // Deep plum
    surface               = Color(0xFFFFFFFF),
    onSurface             = Color(0xFF1A0D2E),
    surfaceVariant        = Color(0xFFEDE7F6), // Light lilac
    onSurfaceVariant      = Color(0xFF6A1B9A),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F),
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFAB47BC),
    outlineVariant        = Color(0xFFD1C4E4),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF1A0D2E),
    inverseOnSurface      = Color(0xFFEDE7F6),
    inversePrimary        = Color(0xFF9575CD),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x991A0D2E)
)

val RoyalVelvetDark = darkColorScheme(
    // ── Primary (Light Amethyst) ────────────────────
    primary               = Color(0xFF9575CD),
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFF4A148C),
    onPrimaryContainer    = Color(0xFFD1C4E4),

    // ── Secondary (Soft Magenta) ───────────────────
    secondary             = Color(0xFFBA68C8),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFF6A1B9A),
    onSecondaryContainer  = Color(0xFFE1BEE7),

    // ── Tertiary (Royal Purple) ───────────────────
    tertiary              = Color(0xFF7E57C2),
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFF311B92),
    onTertiaryContainer   = Color(0xFFB39DDB),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF1A0D2E), // Deep velvet night
    onBackground          = Color(0xFFEDE7F6), // Light lilac text
    surface               = Color(0xFF24163A), // Raised velvet
    onSurface             = Color(0xFFEDE7F6),
    surfaceVariant        = Color(0xFF2E1F42),
    onSurfaceVariant      = Color(0xFFBA68C8),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252),
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF9575CD),
    outlineVariant        = Color(0xFF7E57C2),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFF5F3FF),
    inverseOnSurface      = Color(0xFF1A0D2E),
    inversePrimary        = Color(0xFF4A148C),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)
)

// SunsetDunes
val SunsetDunesLight = lightColorScheme(
    // ── Primary (Coral Orange) ──────────────────────
    primary               = Color(0xFFFF8A65),
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFFFFCCBC),
    onPrimaryContainer    = Color(0xFFD84315),

    // ── Secondary (Golden Amber) ───────────────────
    secondary             = Color(0xFFFFB74D),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFFFE0B2),
    onSecondaryContainer  = Color(0xFFEF6C00),

    // ── Tertiary (Burnt Sienna) ────────────────────
    tertiary              = Color(0xFFF4511E),
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFFFFAB91),
    onTertiaryContainer   = Color(0xFFBF360C),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFFFF8F5), // Warm cream
    onBackground          = Color(0xFF261914), // Deep umber
    surface               = Color(0xFFFFFFFF),
    onSurface             = Color(0xFF261914),
    surfaceVariant        = Color(0xFFFFEDE4), // Light peach
    onSurfaceVariant      = Color(0xFF8D6E63),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F),
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFFFB74D),
    outlineVariant        = Color(0xFFFFCCBC),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF261914),
    inverseOnSurface      = Color(0xFFFBE9E7),
    inversePrimary        = Color(0xFFFFAB91),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99261914)
)

val SunsetDunesDark = darkColorScheme(
    // ── Primary (Light Coral) ───────────────────────
    primary               = Color(0xFFFFAB91),
    onPrimary             = Color(0xFF000000),
    primaryContainer      = Color(0xFFD84315),
    onPrimaryContainer    = Color(0xFFFFCCBC),

    // ── Secondary (Soft Amber) ─────────────────────
    secondary             = Color(0xFFFFCC80),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFEF6C00),
    onSecondaryContainer  = Color(0xFFFFE0B2),

    // ── Tertiary (Fiery Orange) ───────────────────
    tertiary              = Color(0xFFFF7043),
    onTertiary            = Color(0xFF000000),
    tertiaryContainer     = Color(0xFFBF360C),
    onTertiaryContainer   = Color(0xFFFFAB91),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF261914), // Deep desert night
    onBackground          = Color(0xFFFBE9E7), // Warm light text
    surface               = Color(0xFF3A2A22), // Raised sand
    onSurface             = Color(0xFFFBE9E7),
    surfaceVariant        = Color(0xFF4A362D),
    onSurfaceVariant      = Color(0xFFFFCC80),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252),
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFFFFAB91),
    outlineVariant        = Color(0xFFFF8A65),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFFFF8F5),
    inverseOnSurface      = Color(0xFF261914),
    inversePrimary        = Color(0xFFD84315),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)
)

// MidnightSapphire
val MidnightSapphireLight = lightColorScheme(
    // ── Primary (Golden Sapphire) ───────────────────
    primary               = Color(0xFFFFD700), // Rich gold (was Color.Yellow)
    onPrimary             = Color(0xFF000000), // Black for contrast
    primaryContainer      = Color(0xFFFFF59D), // Pale gold
    onPrimaryContainer    = Color(0xFFB8860B), // Deep gold

    // ── Secondary (Sky Blue) ───────────────────────
    secondary             = Color(0xFF42A5F5), // Bright blue
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFFBBDEFB),
    onSecondaryContainer  = Color(0xFF1565C0),

    // ── Tertiary (Deep Sapphire) ───────────────────
    tertiary              = Color(0xFF0D47A1), // Midnight blue
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFF90CAF9),
    onTertiaryContainer   = Color(0xFF0A2E6E),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFFF5FBFF), // Icy starlight white
    onBackground          = Color(0xFF0A1120), // Deep midnight
    surface               = Color(0xFFFFFFFF),
    onSurface             = Color(0xFF0A1120),
    surfaceVariant        = Color(0xFFE8F0FE), // Light sapphire tint
    onSurfaceVariant      = Color(0xFF1E3A8A),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFD32F2F),
    onError               = Color(0xFFFFFFFF),
    errorContainer        = Color(0xFFFFEBEE),
    onErrorContainer      = Color(0xFFB71C1C),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF42A5F5),
    outlineVariant        = Color(0xFF90CAF9),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFF0A1120),
    inverseOnSurface      = Color(0xFFE3F2FD),
    inversePrimary        = Color(0xFF1A237E), // Deep sapphire

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x990A1120)
)

val MidnightSapphireDark = darkColorScheme(
    // ── Primary (Deep Indigo Sapphire) ─────────────
    primary               = Color(0xFF1A237E), // Rich sapphire (was Color.DarkGray)
    onPrimary             = Color(0xFFFFFFFF),
    primaryContainer      = Color(0xFF0D1B5C), // Darker void
    onPrimaryContainer    = Color(0xFFB3C7FF),

    // ── Secondary (Light Sky Blue) ─────────────────
    secondary             = Color(0xFF90CAF9),
    onSecondary           = Color(0xFF000000),
    secondaryContainer    = Color(0xFF1565C0),
    onSecondaryContainer  = Color(0xFFBBDEFB),

    // ── Tertiary (Vivid Blue) ─────────────────────
    tertiary              = Color(0xFF1976D2),
    onTertiary            = Color(0xFFFFFFFF),
    tertiaryContainer     = Color(0xFF0A2E6E),
    onTertiaryContainer   = Color(0xFF90CAF9),

    // ── Background & Surface ───────────────────────
    background            = Color(0xFF0A1120), // Deep midnight
    onBackground          = Color(0xFFE3F2FD), // Light sapphire glow
    surface               = Color(0xFF121826), // Raised panel
    onSurface             = Color(0xFFE3F2FD),
    surfaceVariant        = Color(0xFF1A2333),
    onSurfaceVariant      = Color(0xFF90CAF9),

    // ── Error ───────────────────────────────────────
    error                 = Color(0xFFFF5252),
    onError               = Color(0xFF000000),
    errorContainer        = Color(0xFF5D1E1E),
    onErrorContainer      = Color(0xFFFFB4B4),

    // ── Outline ─────────────────────────────────────
    outline               = Color(0xFF90CAF9),
    outlineVariant        = Color(0xFF42A5F5),

    // ── Inverse ─────────────────────────────────────
    inverseSurface        = Color(0xFFF5FBFF),
    inverseOnSurface      = Color(0xFF0A1120),
    inversePrimary        = Color(0xFFFFD700),

    // ── Utility ─────────────────────────────────────
    scrim                 = Color(0x99000000)
)

//// // -----------------------------------------------------
//val MinimalistLight = lightColorScheme(
//    primary = Color(0xFF000000), onPrimary = Color(0xFFFFFFFF),
//    primaryContainer = Color(0xFFF7FAFC), onPrimaryContainer = Color(0xFF1A202C),
//    secondary = Color(0xFF4A5568), onSecondary = Color(0xFFFFFFFF),
//    secondaryContainer = Color(0xFFEDF2F7), onSecondaryContainer = Color(0xFF2D3748),
//    tertiary = Color(0xFF718096), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFFE2E8F0), onTertiaryContainer = Color(0xFF4A5568),
//    background = Color(0xFFFFFFFF), onBackground = Color(0xFF1A202C),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF1A202C),
//    surfaceVariant = Color(0xFFF7FAFC), onSurfaceVariant = Color(0xFF718096),
//    error = Color(0xFFE53E3E), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFF5F5), onErrorContainer = Color(0xFFC53030),
//    outline = Color(0xFFE2E8F0), outlineVariant = Color(0xFFEDF2F7),
//    inverseSurface = Color(0xFF1A202C), inverseOnSurface = Color(0xFFFFFFFF),
//    inversePrimary = Color(0xFFCBD5E0), scrim = Color(0x991A202C)
//)
//
//val MinimalistDark = darkColorScheme(
//    primary = Color(0xFFFFFFFF), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFF1A202C), onPrimaryContainer = Color(0xFFE2E8F0),
//    secondary = Color(0xFFCBD5E0), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF2D3748), onSecondaryContainer = Color(0xFFE2E8F0),
//    tertiary = Color(0xFFA0AEC0), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFF4A5568), onTertiaryContainer = Color(0xFFEDF2F7),
//    background = Color(0xFF0F1419), onBackground = Color(0xFFE2E8F0),
//    surface = Color(0xFF1A202C), onSurface = Color(0xFFE2E8F0),
//    surfaceVariant = Color(0xFF2D3748), onSurfaceVariant = Color(0xFFA0AEC0),
//    error = Color(0xFFFC8181), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF742A2A), onErrorContainer = Color(0xFFFED7D7),
//    outline = Color(0xFF4A5568), outlineVariant = Color(0xFF2D3748),
//    inverseSurface = Color(0xFFE2E8F0), inverseOnSurface = Color(0xFF1A202C),
//    inversePrimary = Color(0xFF2D3748), scrim = Color(0x99000000)
//)
//
//val ForestWhisperLight = lightColorScheme(
//    primary = Color(0xFF2E8B57), onPrimary = Color(0xFFFFFFFF),
//    primaryContainer = Color(0xFFC8E6C9), onPrimaryContainer = Color(0xFF1B5E20),
//    secondary = Color(0xFF8FBC8F), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFDFF0D8), onSecondaryContainer = Color(0xFF336633),
//    tertiary = Color(0xFFA0522D), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFFDAB28A), onTertiaryContainer = Color(0xFF5D2F10),
//    background = Color(0xFFF8FFF8), onBackground = Color(0xFF1B2E1B),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF1B2E1B),
//    surfaceVariant = Color(0xFFE8F5E9), onSurfaceVariant = Color(0xFF557755),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFFA5D6A7), outlineVariant = Color(0xFFC8E6C9),
//    inverseSurface = Color(0xFF1B2E1B), inverseOnSurface = Color(0xFFFFFFFF),
//    inversePrimary = Color(0xFF81C784), scrim = Color(0x991B2E1B)
//)
//
//val ForestWhisperDark = darkColorScheme(
//    primary = Color(0xFF66BB6A), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFF2E7D32), onPrimaryContainer = Color(0xFFC8E6C9),
//    secondary = Color(0xFFA5D6A7), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF558B2F), onSecondaryContainer = Color(0xFFDFF0D8),
//    tertiary = Color(0xFFBCAAA4), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFF8D6E63), onTertiaryContainer = Color(0xFFFFD7B5),
//    background = Color(0xFF121F15), onBackground = Color(0xFFE8F5E8),
//    surface = Color(0xFF1A2E1B), onSurface = Color(0xFFE8F5E8),
//    surfaceVariant = Color(0xFF2E3B2F), onSurfaceVariant = Color(0xFFA5D6A7),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFF66BB6A), outlineVariant = Color(0xFF4CAF50),
//    inverseSurface = Color(0xFFE8F5E8), inverseOnSurface = Color(0xFF1B2E1B),
//    inversePrimary = Color(0xFF2E7D32), scrim = Color(0x99000000)
//)
//
//val SolarFlareLight = lightColorScheme(
//    primary = Color(0xFFFF6B35), onPrimary = Color(0xFFFFFFFF),
//    primaryContainer = Color(0xFFFFE0B2), onPrimaryContainer = Color(0xFFB71C1C),
//    secondary = Color(0xFFFFD166), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFFFF3E0), onSecondaryContainer = Color(0xFF8B4513),
//    tertiary = Color(0xFFFF4B6B), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFFFFC1CC), onTertiaryContainer = Color(0xFFC2185B),
//    background = Color(0xFFFFFBFA), onBackground = Color(0xFF2D1B00),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF2D1B00),
//    surfaceVariant = Color(0xFFFFF0E6), onSurfaceVariant = Color(0xFF8B4513),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFFFFB74D), outlineVariant = Color(0xFFFFE0B2),
//    inverseSurface = Color(0xFF2D1B00), inverseOnSurface = Color(0xFFFFFFFF),
//    inversePrimary = Color(0xFFFF8A65), scrim = Color(0x992D1B00)
//)
//
//val SolarFlareDark = darkColorScheme(
//    primary = Color(0xFFFF8A65), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFE65100), onPrimaryContainer = Color(0xFFFFE0B2),
//    secondary = Color(0xFFFFE082), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFFFB74D), onSecondaryContainer = Color(0xFFFFF3E0),
//    tertiary = Color(0xFFFF8A99), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFFC2185B), onTertiaryContainer = Color(0xFFFFC1CC),
//    background = Color(0xFF2D1B2E), onBackground = Color(0xFFFFF3E0),
//    surface = Color(0xFF3A1F22), onSurface = Color(0xFFFFF3E0),
//    surfaceVariant = Color(0xFF4A2A2D), onSurfaceVariant = Color(0xFFFFB74D),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFFFFB74D), outlineVariant = Color(0xFFFF8A65),
//    inverseSurface = Color(0xFFFFF3E0), inverseOnSurface = Color(0xFF2D1B00),
//    inversePrimary = Color(0xFFE65100), scrim = Color(0x99000000)
//)
//
//val CyberNeonLight = lightColorScheme(
//    primary = Color(0xFF00FFEA), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFB2FFFF), onPrimaryContainer = Color(0xFF006064),
//    secondary = Color(0xFFFF00E6), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFFFB2FF), onSecondaryContainer = Color(0xFF6A1B9A),
//    tertiary = Color(0xFF00FF7F), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFFB2FFB2), onTertiaryContainer = Color(0xFF1B5E20),
//    background = Color(0xFFFFFFFF), onBackground = Color(0xFF000000),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF000000),
//    surfaceVariant = Color(0xFFF0F0F5), onSurfaceVariant = Color(0xFF555566),
//    error = Color(0xFFFF1744), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFD1D1), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFF00E5FF), outlineVariant = Color(0xFFB2FFFF),
//    inverseSurface = Color(0xFF0A0A12), inverseOnSurface = Color(0xFFE0E0E0),
//    inversePrimary = Color(0xFF00BFA5), scrim = Color(0x99000000)
//)
//
//val CyberNeonDark = darkColorScheme(
//    primary = Color(0xFF00FFEA), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFF006064), onPrimaryContainer = Color(0xFFB2FFFF),
//    secondary = Color(0xFFFF00E6), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF6A1B9A), onSecondaryContainer = Color(0xFFFFB2FF),
//    tertiary = Color(0xFF00FF7F), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFF1B5E20), onTertiaryContainer = Color(0xFFB2FFB2),
//    background = Color(0xFF0A0A12), onBackground = Color(0xFFE0E0E0),
//    surface = Color(0xFF11111B), onSurface = Color(0xFFE0E0E0),
//    surfaceVariant = Color(0xFF1E1E2E), onSurfaceVariant = Color(0xFF00E5FF),
//    error = Color(0xFFFF3E5E), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFF00E5FF), outlineVariant = Color(0xFF00BFA5),
//    inverseSurface = Color(0xFFFFFFFF), inverseOnSurface = Color(0xFF000000),
//    inversePrimary = Color(0xFF00BFA5), scrim = Color(0x99000000)
//)
//
//val ArcticFrostLight = lightColorScheme(
//    primary = Color(0xFF4FC3F7), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFB3E5FC), onPrimaryContainer = Color(0xFF01579B),
//    secondary = Color(0xFF81D4FA), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFE1F5FE), onSecondaryContainer = Color(0xFF0277BD),
//    tertiary = Color(0xFF0288D1), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFF81D4FA), onTertiaryContainer = Color(0xFF0D47A1),
//    background = Color(0xFFF8FDFF), onBackground = Color(0xFF0A1E29),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF0A1E29),
//    surfaceVariant = Color(0xFFE3F2FD), onSurfaceVariant = Color(0xFF2962FF),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFF81D4FA), outlineVariant = Color(0xFFB3E5FC),
//    inverseSurface = Color(0xFF0A1E29), inverseOnSurface = Color(0xFFE1F5FE),
//    inversePrimary = Color(0xFF0277BD), scrim = Color(0x990A1E29)
//)
//
//val ArcticFrostDark = darkColorScheme(
//    primary = Color(0xFF4FC3F7), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFF01579B), onPrimaryContainer = Color(0xFFB3E5FC),
//    secondary = Color(0xFFB3E5FC), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF0277BD), onSecondaryContainer = Color(0xFFE1F5FE),
//    tertiary = Color(0xFF29B6F6), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFF0D47A1), onTertiaryContainer = Color(0xFF81D4FA),
//    background = Color(0xFF0A1E29), onBackground = Color(0xFFE1F5FE),
//    surface = Color(0xFF112E3C), onSurface = Color(0xFFE1F5FE),
//    surfaceVariant = Color(0xFF1C3A4D), onSurfaceVariant = Color(0xFF81D4FA),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFF4FC3F7), outlineVariant = Color(0xFF29B6F6),
//    inverseSurface = Color(0xFFF8FDFF), inverseOnSurface = Color(0xFF0A1E29),
//    inversePrimary = Color(0xFF0277BD), scrim = Color(0x99000000)
//)
//
//val RoyalVelvetLight = lightColorScheme(
//    primary = Color(0xFF7E57C2), onPrimary = Color(0xFFFFFFFF),
//    primaryContainer = Color(0xFFD1C4E4), onPrimaryContainer = Color(0xFF4A148C),
//    secondary = Color(0xFFAB47BC), onSecondary = Color(0xFFFFFFFF),
//    secondaryContainer = Color(0xFFE1BEE7), onSecondaryContainer = Color(0xFF6A1B9A),
//    tertiary = Color(0xFF5E35B1), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFFB39DDB), onTertiaryContainer = Color(0xFF311B92),
//    background = Color(0xFFF5F3FF), onBackground = Color(0xFF1A0D2E),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF1A0D2E),
//    surfaceVariant = Color(0xFFEDE7F6), onSurfaceVariant = Color(0xFF6A1B9A),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFFAB47BC), outlineVariant = Color(0xFFD1C4E4),
//    inverseSurface = Color(0xFF1A0D2E), inverseOnSurface = Color(0xFFEDE7F6),
//    inversePrimary = Color(0xFF9575CD), scrim = Color(0x991A0D2E)
//)
//
//val RoyalVelvetDark = darkColorScheme(
//    primary = Color(0xFF9575CD), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFF4A148C), onPrimaryContainer = Color(0xFFD1C4E4),
//    secondary = Color(0xFFBA68C8), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF6A1B9A), onSecondaryContainer = Color(0xFFE1BEE7),
//    tertiary = Color(0xFF7E57C2), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFF311B92), onTertiaryContainer = Color(0xFFB39DDB),
//    background = Color(0xFF1A0D2E), onBackground = Color(0xFFEDE7F6),
//    surface = Color(0xFF24163A), onSurface = Color(0xFFEDE7F6),
//    surfaceVariant = Color(0xFF2E1F42), onSurfaceVariant = Color(0xFFBA68C8),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFF9575CD), outlineVariant = Color(0xFF7E57C2),
//    inverseSurface = Color(0xFFF5F3FF), inverseOnSurface = Color(0xFF1A0D2E),
//    inversePrimary = Color(0xFF4A148C), scrim = Color(0x99000000)
//)
//
//val SunsetDunesLight = lightColorScheme(
//    primary = Color(0xFFFF8A65), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFFFCCBC), onPrimaryContainer = Color(0xFFD84315),
//    secondary = Color(0xFFFFB74D), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFFFE0B2), onSecondaryContainer = Color(0xFFEF6C00),
//    tertiary = Color(0xFFF4511E), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFFFFAB91), onTertiaryContainer = Color(0xFFBF360C),
//    background = Color(0xFFFFF8F5), onBackground = Color(0xFF261914),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF261914),
//    surfaceVariant = Color(0xFFFFEDE4), onSurfaceVariant = Color(0xFF8D6E63),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFFFFB74D), outlineVariant = Color(0xFFFFCCBC),
//    inverseSurface = Color(0xFF261914), inverseOnSurface = Color(0xFFFBE9E7),
//    inversePrimary = Color(0xFFFFAB91), scrim = Color(0x99261914)
//)
//
//val SunsetDunesDark = darkColorScheme(
//    primary = Color(0xFFFFAB91), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFD84315), onPrimaryContainer = Color(0xFFFFCCBC),
//    secondary = Color(0xFFFFCC80), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFEF6C00), onSecondaryContainer = Color(0xFFFFE0B2),
//    tertiary = Color(0xFFFF7043), onTertiary = Color(0xFF000000),
//    tertiaryContainer = Color(0xFFBF360C), onTertiaryContainer = Color(0xFFFFAB91),
//    background = Color(0xFF261914), onBackground = Color(0xFFFBE9E7),
//    surface = Color(0xFF3A2A22), onSurface = Color(0xFFFBE9E7),
//    surfaceVariant = Color(0xFF4A362D), onSurfaceVariant = Color(0xFFFFCC80),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFFFFAB91), outlineVariant = Color(0xFFFF8A65),
//    inverseSurface = Color(0xFFFFF8F5), inverseOnSurface = Color(0xFF261914),
//    inversePrimary = Color(0xFFD84315), scrim = Color(0x99000000)
//)
//
//val MidnightSapphireLight = lightColorScheme(
//    primary = Color(0xFFFFD700), onPrimary = Color(0xFF000000),
//    primaryContainer = Color(0xFFFFF59D), onPrimaryContainer = Color(0xFFB8860B),
//    secondary = Color(0xFF42A5F5), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFFBBDEFB), onSecondaryContainer = Color(0xFF1565C0),
//    tertiary = Color(0xFF0D47A1), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFF90CAF9), onTertiaryContainer = Color(0xFF0A2E6E),
//    background = Color(0xFFF5FBFF), onBackground = Color(0xFF0A1120),
//    surface = Color(0xFFFFFFFF), onSurface = Color(0xFF0A1120),
//    surfaceVariant = Color(0xFFE8F0FE), onSurfaceVariant = Color(0xFF1E3A8A),
//    error = Color(0xFFD32F2F), onError = Color(0xFFFFFFFF),
//    errorContainer = Color(0xFFFFEBEE), onErrorContainer = Color(0xFFB71C1C),
//    outline = Color(0xFF42A5F5), outlineVariant = Color(0xFF90CAF9),
//    inverseSurface = Color(0xFF0A1120), inverseOnSurface = Color(0xFFE3F2FD),
//    inversePrimary = Color(0xFF1A237E), scrim = Color(0x990A1120)
//)
//
//val MidnightSapphireDark = darkColorScheme(
//    primary = Color(0xFF1A237E), onPrimary = Color(0xFFFFFFFF),
//    primaryContainer = Color(0xFF0D1B5C), onPrimaryContainer = Color(0xFFB3C7FF),
//    secondary = Color(0xFF90CAF9), onSecondary = Color(0xFF000000),
//    secondaryContainer = Color(0xFF1565C0), onSecondaryContainer = Color(0xFFBBDEFB),
//    tertiary = Color(0xFF1976D2), onTertiary = Color(0xFFFFFFFF),
//    tertiaryContainer = Color(0xFF0A2E6E), onTertiaryContainer = Color(0xFF90CAF9),
//    background = Color(0xFF0A1120), onBackground = Color(0xFFE3F2FD),
//    surface = Color(0xFF121826), onSurface = Color(0xFFE3F2FD),
//    surfaceVariant = Color(0xFF1A2333), onSurfaceVariant = Color(0xFF90CAF9),
//    error = Color(0xFFFF5252), onError = Color(0xFF000000),
//    errorContainer = Color(0xFF5D1E1E), onErrorContainer = Color(0xFFFFB4B4),
//    outline = Color(0xFF90CAF9), outlineVariant = Color(0xFF42A5F5),
//    inverseSurface = Color(0xFFF5FBFF), inverseOnSurface = Color(0xFF0A1120),
//    inversePrimary = Color(0xFFFFD700), scrim = Color(0x99000000)
//)

