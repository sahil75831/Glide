package com.example.glide.auth.di

import com.example.glide.auth.data.remote.AuthService
import com.example.glide.auth.utils.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(EndPoints.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit):AuthService {
        return retrofit.create(AuthService::class.java)
    }
}