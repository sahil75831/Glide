package com.example.glide.auth.di

import com.example.glide.auth.data.repository.AuthRepositoryImpl
import com.example.glide.auth.domain.repository.AuthRepository
import dagger.Binds
import javax.inject.Singleton

abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}