package com.kuldeep.jetpackcomposecrashcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuldeep.jetpackcomposecrashcourse.ui.theme.JetpackComposeCrashCourseTheme

class CustomizedListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCrashCourseTheme {
                var inputName by remember {
                    mutableStateOf("")
                }
                var nameList by remember {
                    mutableStateOf(listOf<String>())
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        TextField(
                            label = { Text(text = "Enter something") },
                            value = inputName,
                            modifier = Modifier.weight(1f),
                            onValueChange = {
                                inputName = it
                            })

                        Button(modifier = Modifier.padding(start = 8.dp),
                            onClick = {
                                if (inputName.isNotEmpty()) {
                                    nameList = nameList + inputName
                                    inputName = ""
                                }
                            }) {
                            Text(text = "Add")
                        }

                        Button(
                            modifier = Modifier.padding(start = 8.dp),
                            onClick = { nameList = listOf() }
                        ) {
                            Text(text = "Clear")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    NameListView(nameList = nameList)
                }
            }
        }
    }
}

@Composable
fun NameListView(nameList: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        itemsIndexed(nameList) { index, name ->
            val displayIndex = index + 1
            Text(
                text = "$displayIndex. $name",
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxSize()
            )
            Divider()
        }
    }
}
