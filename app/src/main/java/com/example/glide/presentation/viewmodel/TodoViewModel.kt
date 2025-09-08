package com.example.glide.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.glide.domain.model.Todo
import com.example.glide.domain.usecase.AddTodoUseCase
import com.example.glide.domain.usecase.DeleteTodoUseCase
import com.example.glide.domain.usecase.GetTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val addTodos: AddTodoUseCase,
    private val getTodos: GetTodosUseCase,
    private val deleteTodo: DeleteTodoUseCase
) : ViewModel() {
    val todoList = getTodos().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun add(title:String, description: String){
        viewModelScope.launch {
            addTodos(Todo(title = title, description = description))
        }

    }

    fun delete(todo: Todo) {
        viewModelScope.launch {
            deleteTodo(todo)
        }
    }
}