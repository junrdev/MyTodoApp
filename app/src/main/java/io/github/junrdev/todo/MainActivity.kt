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
import dagger.hilt.android.AndroidEntryPoint
import io.github.junrdev.todo.ui.theme.TodoTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    private lateinit var context: TodoApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            App {
                Toast.makeText(context, "Working", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Composable
fun App(content : @Composable () -> Unit) {

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
    }
}