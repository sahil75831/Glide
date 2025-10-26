package com.example.glide.workspace.workspace_theme.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.workspace.workspace_theme.domain.models.Theme
import com.example.glide.workspace.workspace_theme.domain.usecases.GetThemeUseCase
import com.example.glide.workspace.workspace_theme.domain.usecases.SaveThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class ThemeViewModel @Inject constructor(
    private val getThemeUseCase: GetThemeUseCase,
    private val saveThemeUseCase: SaveThemeUseCase
): ViewModel() {
    val theme = getThemeUseCase().stateIn(viewModelScope, SharingStarted.Eagerly, Theme.Minimalist)

    fun changeTheme(theme: Theme) {
        viewModelScope.launch {
            saveThemeUseCase(theme)
        }
    }
}