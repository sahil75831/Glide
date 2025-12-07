package com.example.glide.workspace.community.data.local


import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommunityLocalDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    companion object {
        private const val KEY_CURRENT_COMMUNITY_ID = "current_community_id"
        private const val KEY_LAST_ACTIVE_COMMUNITY_ID = "last_active_community_id"
    }

    fun saveCurrentCommunityId(communityId: String) {
        prefs.edit().putString(KEY_CURRENT_COMMUNITY_ID, communityId).apply()
    }

    fun getCurrentCommunityId(): String? {
        return prefs.getString(KEY_CURRENT_COMMUNITY_ID, null)
    }

    fun clearCurrentCommunityId() {
        prefs.edit().remove(KEY_CURRENT_COMMUNITY_ID).apply()
    }

    // Optional: Store last active community for future sessions
    fun saveLastActiveCommunityId(communityId: String) {
        prefs.edit().putString(KEY_LAST_ACTIVE_COMMUNITY_ID, communityId).apply()
    }

    fun getLastActiveCommunityId(): String? {
        return prefs.getString(KEY_LAST_ACTIVE_COMMUNITY_ID, null)
    }
}