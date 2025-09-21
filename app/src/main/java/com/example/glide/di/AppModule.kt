package com.example.glide.di

import com.example.glide.data.api.AuthApi
import com.example.glide.data.local.SecureStorage
import com.example.glide.data.repository.AuthRepositoryImpl
import com.example.glide.domain.repository.AuthRepository
import com.example.glide.domain.usecase.ForgotPasswordUseCase
import com.example.glide.domain.usecase.LoginUseCase
import com.example.glide.domain.usecase.LogoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        authApi: AuthApi,
        secureStorage: SecureStorage
    ): AuthRepository = AuthRepositoryImpl(authApi, secureStorage)

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase = LoginUseCase(repository)

    @Provides
    @Singleton
    fun provideLogoutUseCase(repository: AuthRepository): LogoutUseCase = LogoutUseCase(repository)

    @Provides
    @Singleton
    fun provideForgotPasswordUseCase(repository: AuthRepository): ForgotPasswordUseCase = ForgotPasswordUseCase(repository)
}