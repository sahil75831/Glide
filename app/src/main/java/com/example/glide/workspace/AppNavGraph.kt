package com.example.glide.workspace

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.glide.workspace.auth.presentation.screens.OtpScreen
import com.example.glide.workspace.auth.presentation.screens.RegisterUserScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "register") {
        composable(route = "register") {
            RegisterUserScreen(
                onSuccess = { phone: String, email: String ->
                    navController.navigate("otp/$phone/$email")
                }
            )
        }
        composable(route = "otp/{phone}/{email}") { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""

            OtpScreen(
                phone = phone,
                email = email,
                onSuccess = {
                    // Navigate to next screen after successful OTP verification
                    navController.navigate("home")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        // Add more screens as needed
        composable(route = "home") {
            // Your home screen here
            Text("Welcome to Home!")
        }
    }
}