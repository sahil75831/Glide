package com.example.glide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.workspace.auth.presentation.screen.SignUpScreen
import com.example.glide.workspace.auth.presentation.screen.VerifyOtpScreen
import com.example.glide.workspace.auth.presentation.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.glide.workspace.ui.theme.GlideTheme
import com.example.glide.workspace.welcome.presentation.screens.Welcome
import androidx.navigation.NavType
import androidx.navigation.navArgument

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge display
        setContent {
            GlideTheme {
                // Use Surface as the root composable to set the background
                Surface(
                    modifier = Modifier
                        .fillMaxSize() // Ensure it fills the entire available space
                        .background(Color.White),
                ) {
                    // Box to handle content with safe drawing insets
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .safeDrawingPadding() // Adds padding to respect system bars (status, navigation)
                            .background(Color.Transparent) // Your background color
                            .padding(16.dp)
                    ) {
                        // Your content
//                        Welcome()
                        val navController = rememberNavController()
                        AppNavGraph(navController)
                    }
                }
            }
        }
    }
}


object Routes {
    const val WELCOME = "welcome"
    const val SIGN_UP = "sign_up"
    const val VERIFY_OTP = "verify_otp"

    // Route with parameters
    fun verifyOtpRoute(email: String, phone: String): String {
        return "verify_otp?email=$email&phone=$phone"
    }
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.SIGN_UP // You can change this later
    ) {
        composable(Routes.WELCOME) {
            Welcome()
        }


                composable(
                    route = "verify_otp?email={email}&phone={phone}",
                    arguments = listOf(
                        navArgument("email") { type = NavType.StringType; defaultValue = "" },
                        navArgument("phone") { type = NavType.StringType; defaultValue = "" }
                    )
                ) { backStackEntry ->
                    val email = backStackEntry.arguments?.getString("email") ?: ""
                    val phone = backStackEntry.arguments?.getString("phone") ?: ""
                    VerifyOtpScreen(email, phone)
                }



        composable(Routes.SIGN_UP) {
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(navController, viewModel = viewModel)
        }
    }
}
