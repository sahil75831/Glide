package com.example.glide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.domain.repository.AuthRepository
import com.example.glide.ui.auth.ForgotPasswordScreen
import com.example.glide.ui.auth.LoginScreen
import com.example.glide.ui.main.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        val startDestination = if (authRepository.isLoggedIn()) "home" else "login"

        NavHost(navController = navController, startDestination = startDestination) {
            composable("login") { LoginScreen(navController = navController) }
            composable("forgot_password") { ForgotPasswordScreen(navController = navController) }
            composable("home") { HomeScreen(navController = navController) }
        }
    }
}