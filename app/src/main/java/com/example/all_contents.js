==== glide/MainActivity.kt ====
package com.example.glide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // Optional: Enables edge-to-edge display
        setContent {
//            GlideTheme { // Use your app's theme
//            }
        }
    }
}--- ---
==== glide/MyApplication.kt ====
package com.example.glide

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()
--- ---
