package com.example.glide.workspace.workspace_theme.di

import com.example.glide.workspace.workspace_theme.data.repository.ThemeRepositoryImplementation
import com.example.glide.workspace.workspace_theme.domain.repository.ThemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ThemeRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsThemeRepository(themeRepositoryImplementation: ThemeRepositoryImplementation): ThemeRepository
}