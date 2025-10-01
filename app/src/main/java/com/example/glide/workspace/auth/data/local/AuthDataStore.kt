package com.example.glide.workspace.auth.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.authDataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

class AuthDataStore(private val context:Context) {
    companion object {
        val TOKEN_KEY = stringPreferencesKey("auth_token")
    }

    suspend fun saveToken(token: String) {
        context.authDataStore.edit{it -> it[TOKEN_KEY] = token}
    }

    fun getToken(): Flow<String?> {
        return context.authDataStore.data.map { it[TOKEN_KEY] }
    }

    suspend fun clearToken() {
        context.authDataStore.edit { it.remove(TOKEN_KEY) }
    }
}