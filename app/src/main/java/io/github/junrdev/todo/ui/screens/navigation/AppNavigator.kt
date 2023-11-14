package io.github.junrdev.todo.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.junrdev.todo.domain.viewmodel.TodoViewModel
import io.github.junrdev.todo.ui.screens.HomeScreen
import io.github.junrdev.todo.ui.screens.navigation.AppScreens.*
import javax.inject.Inject

@Composable
fun AppNavigator(todoViewModel: TodoViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME.name) {


        composable(route = HOME.name) {
            HomeScreen(navController = navController, todoViewModel = todoViewModel)
        }
    }

}