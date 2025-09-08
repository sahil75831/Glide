package com.example.glide.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.glide.presentation.ui.components.TodoItem
import com.example.glide.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(
    viewModel: TodoViewModel = hiltViewModel(),
    onNavigateToAddTodo: () -> Unit
) {
    val todos by viewModel.todoList.collectAsState()

    Scaffold (
        floatingActionButton = {
            FloatingActionButton (onClick = onNavigateToAddTodo) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            itemsIndexed(todos) { index, todo ->
                Column(Modifier.padding(10.dp).background(Color.LightGray).fillMaxWidth().padding(5.dp)) {
                    Text("${index + 1}. ${todo.title}")
                    Text(" 💡 Desc :  ${todo.description}")
                }


            }

//            Button(onClick = { viewModel.clearAllTodos() }) {
//                Text("Clear All Tasks")
//            }

        }
    }
}
