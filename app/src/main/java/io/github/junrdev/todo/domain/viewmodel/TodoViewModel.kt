package io.github.junrdev.todo.domain.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.junrdev.todo.domain.model.Todo
import io.github.junrdev.todo.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {

    private val todos = MutableStateFlow<List<Todo>>(emptyList())

    val todoList = todos.value

    private val TAG = "TodoViewModel"

    init {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.getTodos().distinctUntilChanged().collect {
                //populating todos
                if (it.isNotEmpty())
                    todos.value = it
                else
                    Log.d(TAG, "Empty list")
            }
        }
    }

    fun getTodos() {
        viewModelScope.launch {
            todoRepository.getTodos()
        }
    }

    fun getTodo(id: String) {
        viewModelScope.launch { todoRepository.getTodo(id) }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch { todoRepository.updateTodo(todo) }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch { todoRepository.deleteTodo(todo) }
    }

    fun deleteTodos() {
        viewModelScope.launch { todoRepository.deleteAll() }
    }

    fun createTodo(todo: Todo) {
        viewModelScope.launch { todoRepository.createTodo(todo) }
    }

}