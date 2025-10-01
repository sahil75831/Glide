package com.example.glide.workspace.auth.di

import com.example.glide.workspace.auth.data.repository.AuthRepositoryImpl
import com.example.glide.workspace.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsAuthRepositoryImpl(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}