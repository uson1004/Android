package com.example.composeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeprac.ui.theme.ComposePracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracTheme {
                val padding = 16.dp
                Column (
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreView() {

}

@Composable
fun TopLevel() {
    val (text, setText) = remember { mutableStateOf("") }

    val todoList = remember { mutableStateListOf<TodoData>() }

    val onSubmit: (String) -> Unit = { _ ->
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(TodoData(key, text))
        setText("")
    }

    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = text,
                onValueChange = {},
                modifier = Modifier.weight(1f),
            )

            Spacer(modifier = Modifier.size(8.dp))

            Button(onClick = { onSubmit(text) }) {
                Text("입력")
            }
        }
    }
}