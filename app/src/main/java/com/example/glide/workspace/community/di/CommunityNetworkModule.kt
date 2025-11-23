package com.example.glide.workspace.community.di
//
//import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
//import com.example.glide.workspace.community.data.remote.api.CommunityApi
//import com.example.glide.workspace.community.network.interceptors.HeaderInterceptor
//import com.example.glide.workspace.core.ApiEndpoints
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object CommunityNetworkModule {
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        headerInterceptor: HeaderInterceptor
//    ): OkHttpClient {
//        val logging = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//        return OkHttpClient.Builder().addInterceptor(headerInterceptor).addInterceptor(logging).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(ApiEndpoints.BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideHeaderInterceptor(
//        authLocalDataSource: AuthLocalDataSource
//    ): HeaderInterceptor {
//        return HeaderInterceptor(authLocalDataSource)
//    }
//
//    @Provides
//    @Singleton
//    fun provideCommunityApi(retrofit: Retrofit): CommunityApi{
//        return retrofit.create(CommunityApi::class.java)
//    }
//}