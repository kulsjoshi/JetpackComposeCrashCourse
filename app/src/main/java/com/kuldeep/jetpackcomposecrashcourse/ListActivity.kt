package com.kuldeep.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuldeep.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                Surface {
                    ShowLazyList()
                }
            }
        }
    }
}

@Composable
private fun ShowLazyList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        RowListView()
        ColumnListView()
    }
}

@Composable
private fun RowListView() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(20) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}

@Composable
private fun ColumnListView() {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)
    ) {
        items(20) {
            Row(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Button(
                    onClick = {
                        println(
                            "Clicked item ${it + 1}"
                        )
                    },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(text = "Item ${it + 1}")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListViewPreview() {
    ShowLazyList()
}


