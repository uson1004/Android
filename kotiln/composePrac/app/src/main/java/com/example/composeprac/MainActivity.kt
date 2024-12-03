package com.example.composeprac

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeprac.ui.theme.ComposePracTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracTheme {
                Column {
                    Greeting("Android")
                    MyApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Text preview")
@Composable
fun GreetingPreview() {
    ComposePracTheme {
        Greeting(name = "Android")
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column (modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(24.dp)) {
            Text(text = "Hello")
            Text(text = name)
        }
    }
}

@Composable
fun TopLevel() { // crud
    var text by remember { mutableStateOf("") }

    val todoList = remember { mutableStateListOf<TodoData>() }

    val onSubmit: (String) -> Unit = { text ->
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(TodoData(key, text))
    }

    Column {
        Row(modifier = Modifier.padding(8.dp)) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it},
                modifier = Modifier.weight(1f),
            )

            Spacer(modifier = Modifier.size(8.dp))

            Button(onClick = { onSubmit(text) }) {
                Text("입력")
            }
        }
    }
}

@Composable
fun BrushGradient() { // wow rainbows
    val rainbowColors: List<Color> = listOf(
        Color.Red,
        Color.Yellow,
        Color.Green,
        Color.Blue,
    )
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    TextField(
        value = text, onValueChange = {text = it}, textStyle = androidx.compose.ui.text.TextStyle(
            brush = brush
        ),
    )
}