package com.example.glide.workspace.core.di


import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import com.example.glide.workspace.auth.data.remote.api.AuthApi
import com.example.glide.workspace.community.data.remote.api.CommunityApi
import com.example.glide.workspace.community.network.interceptors.HeaderInterceptor
import com.example.glide.workspace.core.ApiEndpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // 1) Provide HeaderInterceptor
    @Provides
    @Singleton
    fun provideHeaderInterceptor(
        authLocalDataSource: AuthLocalDataSource
    ): HeaderInterceptor = HeaderInterceptor(authLocalDataSource)

    // 2) Provide OkHttpClient with BOTH logging + header interceptor
    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor) // add token to every request
            .addInterceptor(logging) // add logs
            .build()
    }

    // 3) Provide Retrofit
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiEndpoints.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // 4) Provide APIs
    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideCommunityApi(retrofit: Retrofit): CommunityApi =
        retrofit.create(CommunityApi::class.java)
}
