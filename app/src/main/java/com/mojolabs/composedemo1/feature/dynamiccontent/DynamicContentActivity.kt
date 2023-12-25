package com.mojolabs.composedemo1.feature.dynamiccontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// private val nameList =
//     mutableListOf(
//         "Aayan",
//         "Deepa",
//         "Rahul",
//         "Raghu",
//         "Aditya",
//         "Sureshhhhhhh"
//     )

class DynamicContentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicContentMainScreen()
        }
    }
}

@Composable
private fun DynamicContentMainScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        NameList()
    }
}

@Composable
private fun NameList() {
    val counterState = remember { mutableIntStateOf(0) }

    val namesListState = remember { mutableStateListOf("Name ${counterState.intValue++}") }

    Column(modifier = Modifier.fillMaxSize()) {
        for (name in namesListState) {
            NameText(name = name)
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { namesListState.add("Name ${counterState.intValue++}") }
        ) {
            Text(text = "Add new name")
        }
    }
}

@Composable
private fun NameText(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = name,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun TextPreview() {
    DynamicContentMainScreen()
}
