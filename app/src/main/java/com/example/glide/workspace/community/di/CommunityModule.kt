package com.example.glide.workspace.community.di

import com.example.glide.workspace.community.data.repository.CommunityRepositoryImpl
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommunityModule {
    @Binds
    @Singleton
    abstract fun bindCommunityRepository(communityRepositoryImpl: CommunityRepositoryImpl): CommunityRepository
}