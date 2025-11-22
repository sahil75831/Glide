package com.example.glide.workspace.auth.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    fun saveToken(token: String){
        return prefs.edit().putString("saved_auth_token", token).apply()
    }

    fun getToken(): String? {
        return  prefs.getString("saved_auth_token", null)
    }

    fun clearToken(){
        return prefs.edit().remove("saved_auth_token").apply()
    }
}