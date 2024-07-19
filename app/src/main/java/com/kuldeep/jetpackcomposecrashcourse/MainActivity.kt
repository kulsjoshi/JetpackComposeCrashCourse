package com.kuldeep.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuldeep.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            JetpackComposeCrashCourseTheme {
                Surface {
                    Greeting(
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GreetingText(name = name)
        RowLayout()
        BoxLayout(name = name)
        println("THIS IS NEW CHANGES AND COMMIT")
        println("This is Experimental Branch")
        println("Merge conflict from Experimental Branch")
    }
}

@Composable
fun GreetingText(name: String) {
    Text(
        text = "Hello $name!",
        color = Color.Blue,
        fontSize = 30.sp,
    )
}

@Composable
fun RowLayout() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Row Howdy?",
            modifier = Modifier.background(Color.Red),
            color = Color.DarkGray,
            fontSize = 30.sp
        )
        Text(
            text = "Row Yo?",
            modifier = Modifier.background(Color.Cyan),
            color = Color.DarkGray,
            fontSize = 30.sp
        )
    }
}

@Composable
fun BoxLayout(name: String) {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .background(Color.Black)
                .align(Alignment.BottomEnd)
        )
        if (name == "Kuldeep") {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .size(50.dp)
            )
        } else {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier
                    .size(50.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCrashCourseTheme {
        Greeting("Kuldeep")
    }
}