package com.example.glide.presentation.navigation

sealed class Screen(val route: String) {
    object TodoList : Screen("todo_list")
    object AddTodo : Screen("add_todo")
}
