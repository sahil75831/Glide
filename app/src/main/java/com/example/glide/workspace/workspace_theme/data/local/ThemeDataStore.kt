package com.example.glide.workspace.workspace_theme.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.glide.workspace.core.utils.AppConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

val Context.appDataStore by preferencesDataStore(AppConstants.DATA_STORE_NAME)

@Singleton
class ThemeDataStore(private val context: Context) {
    companion object {
        val themeKey = stringPreferencesKey(AppConstants.THEME_KEY)
    }
    // Flow to observe the theme changes
    val themeFlow: Flow<String?> = context.appDataStore.data
        .map {prefs ->
        val theme = prefs[themeKey]
        theme
    }

    // Function to save the theme
    suspend fun saveTheme(themeName: String) {
        context.appDataStore.edit {
            prefs -> prefs[themeKey] = themeName
            Log.d("ThemeDataStore", "Saved theme $themeName")
        }
    }
}