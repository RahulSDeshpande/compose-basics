package com.mojolabs.composedemo1.feature.dynamiccontent2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class DynamicContent2Activity : ComponentActivity() {

    private val viewModel: DynamicContent2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicContentMainScreen(viewModel)
        }
    }
}

@Composable
private fun DynamicContentMainScreen(
    viewModel: DynamicContent2ViewModel = DynamicContent2ViewModel()
) {
    val nameListState = viewModel.nameListState.observeAsState(mutableListOf("Names\\n------"))

    val newNameState = viewModel.newNameState.observeAsState(initial = "")

    Column(modifier = Modifier.fillMaxSize()) {
        NameList(
            names = nameListState.value,
            buttonClick = { viewModel.updateNameList(newNameState.value) },
            textFieldValue = newNameState.value,
            textFieldUpdate = { viewModel.updateNewName(it) }
        )
    }
}

@Composable
private fun NameList(
    names: MutableList<String>,
    buttonClick: () -> Unit,
    textFieldValue: String,
    textFieldUpdate: (String) -> Unit
) {
    for (name in names) {
        NameText(name = name)
    }

    TextField(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        value = textFieldValue,
        onValueChange = { textFieldUpdate(it) }
    )

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = buttonClick
    ) {
        Text(text = "Add new name")
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
