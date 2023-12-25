package com.mojolabs.composedemo1.feature.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mojolabs.composedemo1.ui.theme.colors

class BasicsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // GreetingText("Text 123")
            // GreetingButton()
            BasicsMainScreen()
        }
    }
}

@Composable
private fun BasicsMainScreen() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Surface(
                color = Color.DarkGray,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Text 1",
                    color = Color.Red,
                    modifier = Modifier.wrapContentSize().padding(16.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Text 2",
                    color = Color.Green,
                    modifier = Modifier.wrapContentSize().padding(8.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Text 3",
                    color = Color.Yellow,
                    modifier = Modifier.wrapContentSize().padding(4.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            Surface(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row {
                    Surface(
                        color = Color.Yellow,
                        modifier = Modifier
                            .height(200.dp)
                            .width(100.dp)
                            .padding(8.dp)
                    ) {}
                    Surface(
                        color = Color.Red,
                        modifier = Modifier
                            .height(200.dp)
                            .width(100.dp)
                            .padding(8.dp)
                    ) {}
                    Surface(
                        color = Color.Green,
                        modifier = Modifier
                            .height(200.dp)
                            .width(100.dp)
                            .padding(8.dp)
                    ) {}
                }
            }

            Surface(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    ColorBox1(colors.random())
                    ColorBox1(colors.random())
                    ColorBox1(colors.random())
                    ColorBox1(colors.random())
                    ColorBox1(colors.random())
                    ColorBox1(colors.random())
                }
            }

            Surface(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    ColorBox2(colors.random())
                    ColorBox2(colors.random())
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Top
                    ) {
                        ColorBox1(colors.random())
                        ColorBox1(colors.random())
                        ColorBox1(colors.random())
                        ColorBox1(colors.random())
                        ColorBox1(colors.random())
                        ColorBox1(colors.random())
                    }
                    ColorBox2(colors.random())
                    ColorBox2(colors.random())
                }
            }
        }
    }
}

@Composable
private fun ColorBox1(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(100.dp)
            .width(50.dp)
            .padding(8.dp)
    ) {}
}

@Composable
private fun ColorBox2(color: Color) {
    Surface(
        color = color,
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
            .padding(2.dp)
    ) {}
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun MainScreenPreview() {
    BasicsMainScreen()
}

@Composable
private fun GreetingText(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .clickable { }
            .height(120.dp)
            .padding(16.dp),
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.SemiBold
        // style = TextStyle(
        //     color = Color.Green,
        //     fontFamily = Typography.bodyLarge.fontFamily,
        //     fontWeight = FontWeight.SemiBold,
        // )

        // modifier = modifier.size(width = 120.dp, height = 80.dp)
        // modifier = modifier.fillMaxWidth()
    )
}

@Composable
private fun GreetingButton() {
    Button(onClick = { }) {
        GreetingText("Button 123")
        GreetingText("Button 456")
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    // GreetingText("Text 123")
    GreetingButton()
}
