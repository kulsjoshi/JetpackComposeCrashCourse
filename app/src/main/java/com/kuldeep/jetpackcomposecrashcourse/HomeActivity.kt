package com.kuldeep.jetpackcomposecrashcourse

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuldeep.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCrashCourseTheme {
                HomeScreenLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.DarkGray)
                )
            }
        }
    }
}

@Composable
private fun HomeScreenLayout(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Kuldeep!",
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            color = MaterialTheme.colorScheme.onPrimary,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            coroutineScope.launch {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        }) {
            Text(text = "Layout Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            coroutineScope.launch {
                val intent = Intent(context, ClickMeActivity::class.java)
                context.startActivity(intent)
            }
        }) {
            Text(text = "Click Me Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            coroutineScope.launch {
                val intent = Intent(context, ListActivity::class.java)
                context.startActivity(intent)
            }
        }) {
            Text(text = "List Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            coroutineScope.launch {
                val intent = Intent(context, CustomizedListActivity::class.java)
                context.startActivity(intent)
            }
        }) {
            Text(text = "Customize List Screen")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreenLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    )
}
