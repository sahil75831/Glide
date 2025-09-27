package com.example.glide.auth.domain.model

sealed class CommunityCreationResult {
    data class Success(val sessionId: String): CommunityCreationResult()
    data class Error(val message: String): CommunityCreationResult()
}