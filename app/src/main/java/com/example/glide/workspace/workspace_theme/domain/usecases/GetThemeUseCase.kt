package com.example.glide.workspace.workspace_theme.domain.usecases

import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow

class GetThemeUseCase(private val themeRepository: ThemeRepository) {
    operator fun invoke(): Flow<Theme> = themeRepository.getThemeFlow()
}