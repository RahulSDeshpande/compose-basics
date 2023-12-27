package com.mojolabs.composedemo1.feature.advancedesign

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.mojolabs.composedemo1.ui.theme.ComposeDemo1Theme

// region USER PROFILE LIST

@Composable
fun UserProfileListScreen(
    userProfileList: List<UserProfileModel>,
    navController: NavHostController?
) {
    Scaffold(topBar = { AppBar(title = "User Profile List") }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(items = userProfileList) { userProfileModel ->
                        UserProfileCard(
                            userProfileModel = userProfileModel,
                            onClick = {
                                navController?.navigate(
                                    route = "user_profile_details/${userProfileModel.id}"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String) {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        title = { Text(text = title) },
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
fun UserProfileCard(
    userProfileModel: UserProfileModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable { onClick.invoke() },
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            UserProfilePicture(
                photoResId = userProfileModel.photo,
                photoUrl = userProfileModel.photoUrl,
                isOnline = userProfileModel.isOnline
            )
            UserProfileContent(
                name = userProfileModel.name,
                designation = userProfileModel.designation
            )
        }
    }
}

@Composable
fun UserProfilePicture(
    photoResId: Int,
    photoUrl: String,
    isOnline: Boolean
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (isOnline) Color.Green else Color.Gray
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Image(
            // painter = painterResource(id = photoResId),
            painter = rememberAsyncImagePainter(model = photoUrl),
            contentDescription = "Android image",
            modifier = Modifier.size(80.dp, 80.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun UserProfileContent(
    name: String,
    designation: String
) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = name,
            modifier = Modifier,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = designation,
            modifier = Modifier
                .padding(top = 4.dp)
                .alpha(0.6f),
            style = MaterialTheme.typography.labelMedium
        )
    }
}

// endregion USER PROFILE LIST

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun UserProfileListPreview() {
    ComposeDemo1Theme {
        UserProfileListScreen(userProfileList, null)
    }
}
