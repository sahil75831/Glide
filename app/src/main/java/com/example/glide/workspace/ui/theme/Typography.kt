//package com.example.glide.workspace.ui.theme
//
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Typography
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.Font
//import androidx.compose.ui.text.font.FontFamily
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.sp
//import com.example.glide.R
//
//// 1️⃣ Define the Poppins font family with all weights
//val Poppins = FontFamily(
//    Font(R.font.poppins_thin, FontWeight.Thin),
//    Font(R.font.poppins_light, FontWeight.Light),
//    Font(R.font.poppins_regular, FontWeight.Normal),
//    Font(R.font.poppins_medium, FontWeight.Medium),
//    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
//    Font(R.font.poppins_bold, FontWeight.Bold),
//    Font(R.font.poppins_black, FontWeight.Black)
//)
//
//// 2️⃣ Define typography with Poppins Light as default for all text styles
//val AppTypography = Typography(
//    displayLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 57.sp,
//        lineHeight = 64.sp
//    ),
//    displayMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 45.sp,
//        lineHeight = 52.sp
//    ),
//    displaySmall = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 36.sp,
//        lineHeight = 44.sp
//    ),
//    headlineLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 32.sp,
//        lineHeight = 40.sp
//    ),
//    headlineMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 28.sp,
//        lineHeight = 36.sp
//    ),
//    headlineSmall = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 24.sp,
//        lineHeight = 32.sp
//    ),
//    titleLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 22.sp,
//        lineHeight = 28.sp
//    ),
//    titleMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 16.sp,
//        lineHeight = 24.sp
//    ),
//    titleSmall = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//    bodyLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 16.sp,
//        lineHeight = 24.sp
//    ),
//    bodyMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//    bodySmall = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 12.sp,
//        lineHeight = 16.sp
//    ),
//    labelLarge = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 14.sp,
//        lineHeight = 20.sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 12.sp,
//        lineHeight = 16.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = Poppins,
//        fontWeight = FontWeight.Light,
//        fontSize = 11.sp,
//        lineHeight = 16.sp
//    )
//)
// workspace/ui/theme/Type.kt (Enhanced version)
package com.example.glide.workspace.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.glide.R

// 1️⃣ Define the Poppins font family with all weights
val Poppins = FontFamily(
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_black, FontWeight.Black)
)

// 2️⃣ Enhanced typography with appropriate weights for each style
val AppTypography = Typography(
    // Display styles - Light weight for large display text
    displayLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 45.sp,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 36.sp,
        lineHeight = 44.sp
    ),

    // Headline styles - Normal weight for better readability
    headlineLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),

    // Title styles - Medium weight for emphasis
    titleLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    // Body styles - Regular weight for comfortable reading
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    // Label styles - Medium weight for interactive elements
    labelLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

//@Composable
//fun GlideTheme(content: @Composable () -> Unit) {
//    MaterialTheme(
////        colorScheme = LightColorScheme, // or your own scheme
//        typography = AppTypography, // ✅ apply Poppins Light globally
//        content = content
//    )
//}