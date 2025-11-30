package com.example.glide.workspace

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.glide.workspace.auth.data.local.AuthLocalDataSource
import com.example.glide.workspace.auth.presentation.screens.LoginUserScreen
import com.example.glide.workspace.auth.presentation.screens.OtpScreen
import com.example.glide.workspace.auth.presentation.screens.RegisterUserScreen
import com.example.glide.workspace.community.presentation.screens.community_gateway.CommunityGateway
import com.example.glide.workspace.community.presentation.screens.create_community.CreateCommunity
import com.example.glide.workspace.core.components.JoinExploreCommunity


@Composable
fun AppNavGraph(
    navController: NavHostController,
    localDataSource: AuthLocalDataSource
) {
    // Read token only once
    val authToken = localDataSource.getToken()

    val startDestination = if (!authToken.isNullOrEmpty()) {
//        "home"
        "join-explore-community"
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
        composable(route = "community-gateway") {
            CommunityGateway(navController)
        }

        composable(route = "create-community"){
            CreateCommunity(navController, onSuccess = {navController.navigate("community-gateway")})
        }

        composable(route = "join-explore-community"){
            JoinExploreCommunity()
        }
    }
}