package com.example.glide.workspace.auth.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.workspace.auth.presentation.screens.CreateCommunity
import com.example.glide.workspace.auth.presentation.screens.HomeScreen
import com.example.glide.workspace.auth.presentation.screens.MainScreen
import com.example.glide.workspace.auth.presentation.screens.VerifyOtpScreen

@Composable
fun AppNavGraph() {
    val navHostController: NavHostController = rememberNavController()
    val modifier = Modifier
    NavHost(navController = navHostController, startDestination = "auth") {
        composable("auth") { MainScreen(modifier = modifier, navHostController) }
        composable(route = "create_community") { CreateCommunity(modifier = modifier, navHostController) }
        composable(route = "verify_otp/{userPhone}/{sessionId}") { backStackEntry ->
            VerifyOtpScreen(
                modifier = modifier,
                navController = navHostController,
                userPhone = backStackEntry.arguments?.getString("userPhone") ?: "",
                sessionId = backStackEntry.arguments?.getString("sessionId") ?: ""
            )
        }
        composable("home") { HomeScreen() }
    }
}