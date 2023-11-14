package io.github.junrdev.todo.repository

import io.github.junrdev.todo.domain.dao.TodoDao
import io.github.junrdev.todo.domain.model.Todo
import javax.inject.Inject


class TodoRepository @Inject constructor(private val todoDao: TodoDao) {

    fun getTodos() = todoDao.getTodos()

    suspend fun getTodo(id: String) = todoDao.getTodoById(id)

    suspend fun createTodo(todo: Todo) {
        todoDao.createTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    suspend fun deleteTodo(todo: Todo){
        todoDao.deleteTodo(todo)
    }

    suspend fun deleteAll(){
        todoDao.deleteAllTodos()
    }

}