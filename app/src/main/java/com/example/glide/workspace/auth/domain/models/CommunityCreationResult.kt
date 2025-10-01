package com.example.glide.workspace.auth.domain.models

sealed class CommunityCreationResult {
    data class Success(val sessionId: String): CommunityCreationResult()
    data class Error(val message: String): CommunityCreationResult()
}