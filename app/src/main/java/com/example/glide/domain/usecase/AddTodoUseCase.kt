package com.example.glide.domain.usecase

import com.example.glide.domain.model.Todo
import com.example.glide.domain.repository.TodoRepository
import javax.inject.Inject

class AddTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo){
        return repository.insert(todo)
    }
}