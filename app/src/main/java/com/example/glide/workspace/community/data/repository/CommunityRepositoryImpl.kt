package com.example.glide.workspace.community.data.repository


import android.util.Log
import com.example.glide.workspace.community.data.mappers.toCreateCommunityRequestDTO
import com.example.glide.workspace.community.data.mappers.toCreateCommunityResult
import com.example.glide.workspace.community.data.mappers.toCreateCurrentCommunityRoleDTO
import com.example.glide.workspace.community.data.mappers.toCreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.data.mappers.toFetchAllPermissions
import com.example.glide.workspace.community.data.mappers.toFetchUserCommunityResult
import com.example.glide.workspace.community.data.mappers.toJoinCommunityNewUserResult
import com.example.glide.workspace.community.data.mappers.toJoinCommunityRequestDTO
import com.example.glide.workspace.community.data.remote.api.CommunityApi
import com.example.glide.workspace.community.domain.models.CreateCommunity
import com.example.glide.workspace.community.domain.models.CreateCommunityResult
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRole
import com.example.glide.workspace.community.domain.models.CreateCurrentCommunityRoleResult
import com.example.glide.workspace.community.domain.models.FetchAllPermissionsResult
import com.example.glide.workspace.community.domain.models.FetchUserCommunityResult
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUser
import com.example.glide.workspace.community.domain.models.JoinCommunityNewUserResult
import com.example.glide.workspace.community.domain.repository.CommunityRepository
import java.io.IOException
import java.net.SocketTimeoutException
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

    override suspend fun fetchUserCommunity(): FetchUserCommunityResult {
        return try {
            val response = api.fetchUserCommunity()
            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    if(body.success){
                        body.toFetchUserCommunityResult()
                    }else{
                        FetchUserCommunityResult(success = false, message = body.message)
                    }
                }else{
                    FetchUserCommunityResult(success = false, message = "Empty response from server")
                }
            }else{
                FetchUserCommunityResult(success = false, message = "Unexpected error", communities = emptyList())
            }
        }catch (e: Exception){
            FetchUserCommunityResult(success = false, message = "Unexpected error", communities = emptyList())
        }
    }

    override suspend fun joinCommunity(joinCommunity: JoinCommunityNewUser): JoinCommunityNewUserResult {
        return try {
            val requestDto = joinCommunity.toJoinCommunityRequestDTO()
            val response = api.joinCommunity(requestDto)

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    if (body.success) {
                        body.toJoinCommunityNewUserResult()
                    } else {
                        // You might want to use the actual message from the server
                        JoinCommunityNewUserResult(
                            success = false,
                            message = body.message ?: "Request failed"
                        )
                    }
                } else {
                    JoinCommunityNewUserResult(
                        success = false,
                        message = "Empty response from server"
                    )
                }
            } else {
                // Consider handling different HTTP error codes more specifically
                val errorMessage = when (response.code()) {
                    400 -> "Bad request"
                    401 -> "Unauthorized"
                    403 -> "Forbidden"
                    404 -> "Community not found"
                    409 -> "Conflict"
                    500 -> "Internal server error"
                    else -> "Unexpected error (${response.code()})"
                }
                JoinCommunityNewUserResult(success = false, message = errorMessage)
            }
        } catch (e: Exception) {
            // Log the exception for debugging
            Log.e("CommunityRepository", "Error joining community", e)

            // Provide a more specific error message based on exception type
            val errorMessage = when (e) {
                is IOException -> "Network error. Please check your connection."
                is SocketTimeoutException -> "Request timeout. Please try again."
                else -> "Unexpected error: ${e.message ?: "Unknown error"}"
            }
            JoinCommunityNewUserResult(success = false, message = errorMessage)
        }
    }

    override suspend fun createCurrentCommunityRole(createCurrentCommunityRole: CreateCurrentCommunityRole): CreateCurrentCommunityRoleResult {
        return try {
            val requestDto = createCurrentCommunityRole.toCreateCurrentCommunityRoleDTO()
            val response = api.createCurrentCommunityRole(requestDto)
            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    if(body.success){
                        body.toCreateCurrentCommunityRoleResult()
                    }else{
                        CreateCurrentCommunityRoleResult(success = false, message = body.message)
                    }
                }else{
                    CreateCurrentCommunityRoleResult(success = false, message = "Empty response from server")
                }
            }else{
                CreateCurrentCommunityRoleResult(success = false, message = "Unexpected error")
            }
        }catch (e: Exception){
            CreateCurrentCommunityRoleResult(success = false, message = "Unexpected error")
        }
    }

    override suspend fun fetchAllPermissions(): FetchAllPermissionsResult {
        return try {
            val response = api.fetchAllPermissions()
            if(response.isSuccessful){
                val body = response.body()
                if(body != null){
                    if(body.success){
                       body.toFetchAllPermissions()
                    }else{
                        FetchAllPermissionsResult(success = false, message = "Unexpected error" , permissions = emptyList())
                    }
                }else{
                    FetchAllPermissionsResult(success = false, message = "Empty response from server", permissions = emptyList() )
                }
            }else{
                FetchAllPermissionsResult(success = false, message = "Unexpected error", permissions = emptyList())
            }
        }catch (e: Exception){
            FetchAllPermissionsResult(success = false, message = "Unexpected error", permissions = emptyList() )
        }
    }
}