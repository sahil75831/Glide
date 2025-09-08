package com.example.glide.domain.repository

import com.example.glide.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>

    suspend fun insert(todo: Todo)

    suspend fun delete(todo: Todo)
}