package com.example.glide.workspace.community.data.repository

import com.example.glide.workspace.auth.data.mappers.toVerifyOtpResult
import com.example.glide.workspace.auth.domain.models.VerifyOtpResult
import com.example.glide.workspace.community.data.mappers.toCreateCommunityRequestDTO
import com.example.glide.workspace.community.data.mappers.toCreateCommunityResult
import com.example.glide.workspace.community.data.remote.api.CommunityApi
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import javax.inject.Inject

class CommunityRepositoryImpl @Inject constructor(
    private val api: CommunityApi
): CommunityRepository {

    override suspend fun createCommunity(createCommunity: CreateCommunity): CreateCommunityResult {
        return try {
            val requestDto = createCommunity.toCreateCommunityRequestDTO()
            val response = api.createCommunity(requestDto)

            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    if (body.success) {
                        body.toCreateCommunityResult()
                    } else {
                        CreateCommunityResult(success = false, message = body.message)
                    }

                }else{
                    CreateCommunityResult(success = false, message = "Empty response from server")
                }
            }else{
                CreateCommunityResult(success = false, message = "Unexpected error")
            }
        }catch (e: Exception){
            CreateCommunityResult(success = false, message = "Unexpected error")
        }
    }

}