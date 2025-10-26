package com.example.glide.workspace.workspace_theme.domain.models

enum class Theme(val displayName: String) {
    Minimalist("Minimalist"),
    CyberNeon("Cyber Neon"),
    SolarFlare("Solar Flare"),
    ForestWhisper("Forest Whisper"),
    ArcticFrost("Arctic Frost"),
    RoyalVelvet("Royal Velvet"),
    SunsetDunes("Sunset Dunes"),
    MidnightSapphire("Midnight Sapphire");

    companion object {
        fun fromName(name: String?): Theme = entries.firstOrNull { it -> it.displayName == name } ?: Minimalist
    }
}