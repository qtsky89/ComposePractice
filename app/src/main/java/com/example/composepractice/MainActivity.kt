package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                /* default backup
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose")) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color=MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal=8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f).padding(bottom=extraPadding)) {
                Text(text = "hello ")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded.value = !expanded.value}) {
                Text(if (expanded.value) "Show more" else "Show less")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        MyApp()
    }
}