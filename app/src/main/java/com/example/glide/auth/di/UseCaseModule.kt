package com.example.glide.auth.di

import com.example.glide.auth.domain.repository.AuthRepository
import com.example.glide.auth.domain.usecases.CreateCommunityUseCase
import com.example.glide.auth.domain.usecases.VerifyOtpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCreateCommunityUseCase(authRepository: AuthRepository): CreateCommunityUseCase {
        return CreateCommunityUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideVerifyOtpUseCase(authRepository: AuthRepository): VerifyOtpUseCase {
        return VerifyOtpUseCase(authRepository)
    }
}