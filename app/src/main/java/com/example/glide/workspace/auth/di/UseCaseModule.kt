package com.example.glide.workspace.auth.di

import com.example.glide.workspace.auth.domain.repository.AuthRepository
import com.example.glide.workspace.auth.domain.usecases.SignUpUseCase
import com.example.glide.workspace.auth.domain.usecases.VerifyOtpUseCase
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
    fun provideSignUpUseCase(
        authRepository: AuthRepository
    ): SignUpUseCase {
        return SignUpUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideVerifyOtpUseCase(authRepository: AuthRepository): VerifyOtpUseCase {
        return VerifyOtpUseCase(authRepository)
    }
}