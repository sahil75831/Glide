package com.example.glide.workspace.auth.di

import android.content.Context
import android.content.SharedPreferences
import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import com.example.glide.workspace.community.data.local.CommunityLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        return context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAuthLocalDataSource(sharedPreferences: SharedPreferences): AuthLocalDataSource {
        return AuthLocalDataSource(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideCommunityLocalDataSource(sharedPreferences: SharedPreferences): CommunityLocalDataSource {
        return CommunityLocalDataSource(sharedPreferences)
    }

}