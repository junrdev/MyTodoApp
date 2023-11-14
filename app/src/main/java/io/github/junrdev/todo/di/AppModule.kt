package io.github.junrdev.todo.di

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.junrdev.todo.TodoApp
import io.github.junrdev.todo.data.TodoDb
import io.github.junrdev.todo.domain.dao.TodoDao
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesContext(@ApplicationContext context: Context): TodoApp {
        return context as TodoApp;
    }

    @Singleton
    @Provides
    fun providesDao(todoDb: TodoDb): TodoDao {
        return todoDb.Tododao()
    }

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): TodoDb {
        return Room.databaseBuilder(context, TodoDb::class.java, "todo_db")
            .fallbackToDestructiveMigration().build()
    }


}