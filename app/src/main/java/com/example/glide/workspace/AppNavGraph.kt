package com.example.glide.workspace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.glide.R
import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import com.example.glide.workspace.auth.presentation.screens.LoginUserScreen
import com.example.glide.workspace.auth.presentation.screens.OtpScreen
import com.example.glide.workspace.auth.presentation.screens.RegisterUserScreen
import com.example.glide.workspace.core.components.TopBarWithAvatarPreview


@Composable
fun AppNavGraph(
    navController: NavHostController,
    localDataSource: AuthLocalDataSource
) {
    // Read token only once
    val authToken = localDataSource.getToken()

    val startDestination = if (!authToken.isNullOrEmpty()) {
        "home"
    } else {
        "login"
    }


    NavHost(navController, startDestination = startDestination) {

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
                    navController.navigate("login")
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = "login"){
            LoginUserScreen(
                onSuccess = {
                    navController.navigate(route = "home")
                }
            )
        }
        // Add more screens as needed
        composable(route = "home") {
            // Your home screen here
//            Text("Welcome to Home! you are already logged in")
            TopBarWithAvatarPreview()

        }
    }
}