package io.github.junrdev.todo

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import io.github.junrdev.todo.domain.viewmodel.TodoViewModel
import io.github.junrdev.todo.ui.screens.navigation.AppNavigator
import io.github.junrdev.todo.ui.theme.TodoTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var context: TodoApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            //creating todo vm
            val todoViewModel: TodoViewModel = viewModel()

            enableEdgeToEdge()
            App {
                AppNavigator(todoViewModel = todoViewModel)
            }
        }
    }
}


@Composable
fun App(content: @Composable () -> Unit) {
    content()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
    }
}