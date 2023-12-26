package com.mojolabs.composedemo1.feature.advancedesigns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mojolabs.composedemo1.R
import com.mojolabs.composedemo1.ui.theme.ComposeDemo1Theme

class AdvanceDesignsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemo1Theme {
                AdvanceDesignsMainScreen()
            }
        }
    }
}

@Composable
private fun AdvanceDesignsMainScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ProfileCard()
    }
}

@Composable
private fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
private fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = Color.Gray),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile_1),
            contentDescription = "Android image",
            modifier = Modifier.size(80.dp, 80.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun ProfileContent() {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "John Doe",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Sr. Software Engineer",
            modifier = Modifier.padding(8.dp).alpha(0.8f),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun AdvanceDesignsPreview() {
    ComposeDemo1Theme {
        AdvanceDesignsMainScreen()
    }
}
