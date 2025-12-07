package com.example.glide.workspace.community.di

import com.example.glide.workspace.community.domain.repository.CommunityRepository
import com.example.glide.workspace.community.domain.usecases.FetchUserCommunityUseCase
import com.example.glide.workspace.community.domain.usecases.JoinCommunityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommunityUseCaseModule {
    @Provides
    @Singleton
    fun provideFetchUserCommunityUseCase(
        communityRepository: CommunityRepository
    ): FetchUserCommunityUseCase {
        return FetchUserCommunityUseCase(communityRepository)
    }

    @Provides
    @Singleton
    fun provideJoinCommunityUseCase(
        communityRepository: CommunityRepository
    ): JoinCommunityUseCase {
        return JoinCommunityUseCase(communityRepository)
    }
}