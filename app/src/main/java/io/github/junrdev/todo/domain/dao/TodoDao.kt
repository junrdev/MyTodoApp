package io.github.junrdev.todo.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.github.junrdev.todo.domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodos() : Flow<List<Todo>>

    @Query("SELECT * FROM Todo WHERE id =:id")
    suspend fun getTodoById(id : String) : Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createTodo(todo: Todo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("DELETE FROM Todo")
    suspend fun deleteAllTodos()
}