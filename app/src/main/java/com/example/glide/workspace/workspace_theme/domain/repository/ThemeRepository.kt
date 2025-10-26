package com.example.glide.workspace.workspace_theme.domain.repository

import com.example.glide.workspace.workspace_theme.domain.models.Theme
import kotlinx.coroutines.flow.Flow

interface ThemeRepository {
    fun getThemeFlow(): Flow<Theme>
    suspend fun saveTheme(theme: Theme)
}