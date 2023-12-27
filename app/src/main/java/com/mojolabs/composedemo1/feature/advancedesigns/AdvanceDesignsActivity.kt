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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mojolabs.composedemo1.ui.theme.ComposeDemo1Theme

class AdvanceDesignsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemo1Theme {
                AdvanceDesignsMainScreen(userProfileList)
            }
        }
    }
}

@Composable
private fun AdvanceDesignsMainScreen(userProfileList: List<UserProfileModel>) {
    Scaffold(topBar = { AppBar() }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(items = userProfileList) {
                        ProfileCard(userProfileModel = it)
                    }
                }

                // Column {
                //     for (userProfileModel in userProfileList) {
                //         ProfileCard(userProfileModel)
                //     }
                // }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text(text = "TopAppBar") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Top app bar nav icon",
                modifier = Modifier.padding(8.dp)
            )
        }
    )
}

@Composable
private fun ProfileCard(userProfileModel: UserProfileModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(
                photoResId = userProfileModel.photo,
                isOnline = userProfileModel.isOnline
            )
            ProfileContent(
                name = userProfileModel.name,
                designation = userProfileModel.designation
            )
        }
    }
}

@Composable
private fun ProfilePicture(
    photoResId: Int,
    isOnline: Boolean
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = if (isOnline) Color.Green else Color.Gray),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Image(
            painter = painterResource(id = photoResId),
            contentDescription = "Android image",
            modifier = Modifier.size(80.dp, 80.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun ProfileContent(
    name: String,
    designation: String
) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = name,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = designation,
            modifier = Modifier
                .padding(8.dp)
                .alpha(0.8f),
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
        AdvanceDesignsMainScreen(userProfileList)
    }
}
