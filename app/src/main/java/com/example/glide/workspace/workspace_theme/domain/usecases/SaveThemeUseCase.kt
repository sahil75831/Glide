package com.example.glide.workspace.workspace_theme.domain.usecases

import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.domain.repository.ThemeRepository

class SaveThemeUseCase(private val themeRepository: ThemeRepository) {
    suspend operator fun invoke(theme: Theme) = themeRepository.saveTheme(theme)
}