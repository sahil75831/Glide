package com.example.glide.domain.repository

import com.example.glide.data.local.TodoDao
import com.example.glide.data.local.TodoEntity
import com.example.glide.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
) : TodoRepository {

    override suspend fun insert(todo: Todo) {
        dao.insert(TodoEntity(
            id = todo.id,
            title = todo.title,
            description = todo.description,
            isDone = todo.isDone
        ))
    }

    override suspend fun delete(todo: Todo) {
        dao.delete(TodoEntity(
            id = todo.id,
            title = todo.title,
            description = todo.description,
            isDone = todo.isDone
        ))
    }

    override fun getTodos(): Flow<List<Todo>> {
        return dao.getTodos().map { entities ->
            entities.map { entity ->
                Todo(
                    id = entity.id,
                    title = entity.title,
                    description = entity.description,
                    isDone = entity.isDone
                )
            }
        }
    }
}
