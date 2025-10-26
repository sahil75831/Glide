package com.example.glide.workspace.workspace_theme.data.repository

import com.example.glide.workspace.workspace_theme.data.local.ThemeDataStore
import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.domain.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemeRepositoryImplementation @Inject constructor(
    private val themeDataStore: ThemeDataStore
): ThemeRepository {
    override fun getThemeFlow(): Flow<Theme> {
        return themeDataStore.themeFlow.map { Theme.fromName(it) }
    }

    override suspend fun saveTheme(theme: Theme) {
        themeDataStore.saveTheme(theme.displayName)
    }
}