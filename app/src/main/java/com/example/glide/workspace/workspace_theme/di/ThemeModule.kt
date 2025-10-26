package com.example.glide.workspace.workspace_theme.di

import android.content.Context
import com.example.glide.workspace.workspace_theme.data.local.ThemeDataStore
import com.example.glide.workspace.workspace_theme.domain.repository.ThemeRepository
import com.example.glide.workspace.workspace_theme.domain.usecases.GetThemeUseCase
import com.example.glide.workspace.workspace_theme.domain.usecases.SaveThemeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThemeModule {
    @Provides
    @Singleton
    fun provideThemeDataSource(@ApplicationContext context: Context): ThemeDataStore {
        return ThemeDataStore(context)
    }

    @Provides
    @Singleton
    fun provideGetThemeUseCase(repository: ThemeRepository): GetThemeUseCase {
        return GetThemeUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSaveThemeUseCase(repository: ThemeRepository): SaveThemeUseCase {
        return SaveThemeUseCase(repository)
    }
}