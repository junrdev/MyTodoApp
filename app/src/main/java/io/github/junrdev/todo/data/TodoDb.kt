package io.github.junrdev.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.junrdev.todo.domain.dao.TodoDao
import io.github.junrdev.todo.domain.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDb : RoomDatabase(){
    abstract fun Tododao(): TodoDao
}