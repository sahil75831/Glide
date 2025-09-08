package com.example.glide.domain.usecase

import com.example.glide.domain.model.Todo
import com.example.glide.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>>{
        return repository.getTodos()
    }
}