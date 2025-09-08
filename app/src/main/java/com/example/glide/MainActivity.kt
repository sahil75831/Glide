package com.example.glide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glide.presentation.navigation.Screen
import com.example.glide.presentation.ui.screens.AddTodoScreen
import com.example.glide.presentation.ui.screens.TodoListScreen
import com.example.glide.ui.theme.GlideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint   // 👈 Required for Hilt
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GlideTheme {
                TodoApp()
                }
            }
        }
    }


@Composable
fun TodoApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.TodoList.route
    ) {
        composable(Screen.TodoList.route) {
            TodoListScreen(
                onNavigateToAddTodo = { navController.navigate(Screen.AddTodo.route) }
            )
        }
        composable(Screen.AddTodo.route) {
            AddTodoScreen(
                onTodoAdded = { title, desc ->
                    // After saving, go back to list
                    navController.popBackStack()
                }
            )


        }
    }
}

