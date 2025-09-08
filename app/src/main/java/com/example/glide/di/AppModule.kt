package com.example.glide.di

import android.app.Application
import androidx.room.Room
import com.example.glide.data.local.TodoDao
import com.example.glide.data.local.TodoDatabase
import com.example.glide.domain.repository.TodoRepository
import com.example.glide.domain.repository.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application):TodoDatabase {
        return Room.databaseBuilder(app, TodoDatabase::class.java, "todo_db").build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao()

    @Provides
    @Singleton
    fun provideTodoRepository(dao: TodoDao): TodoRepository = TodoRepositoryImpl(dao)
}