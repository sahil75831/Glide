package com.example.glide.workspace.community.network.interceptors

import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import com.example.glide.workspace.community.data.local.CommunityLocalDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val communityLocalDataSource: CommunityLocalDataSource
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = authLocalDataSource.getToken()
        val currentCommunityId = communityLocalDataSource.getCurrentCommunityId()
        val requestBuilder = chain.request().newBuilder()

        if (!token.isNullOrBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        if(!currentCommunityId.isNullOrBlank()){
            requestBuilder.addHeader(name = "x-community-id", value = currentCommunityId)
        }

        return chain.proceed(requestBuilder.build())
    }
}
