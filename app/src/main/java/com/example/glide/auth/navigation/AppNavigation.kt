package com.example.glide.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.auth.presentation.view.CreateCommunityScreen
import com.example.glide.auth.presentation.view.HomeScreen
import com.example.glide.auth.presentation.view.OtpScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("create") {
            CreateCommunityScreen(navController)
        }
        composable("otp/{phone}") { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            OtpScreen(phone, navController)
        }
        composable("home") {
            HomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavHostController) {
    androidx.compose.foundation.layout.Column {
        androidx.compose.material3.Button(onClick = { navController.navigate("create") }) {
            androidx.compose.material3.Text("Start Creating Community")
        }
    }
}