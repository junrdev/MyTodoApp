package io.github.junrdev.todo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Todo(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String?,
    val content: String?,
    val isDone: Boolean = false
)
