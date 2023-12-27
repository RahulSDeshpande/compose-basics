package com.mojolabs.composedemo1.feature.advancedesign

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mojolabs.composedemo1.ui.theme.ComposeDemo1Theme

// region USER PROFILE DETAILS

@Composable
fun UserProfileDetailsScreen(userId: String?) {
    Scaffold(topBar = { AppBar(title = "User Profile Details") }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                UserProfileDetailsCard(
                    userProfileModel = userProfileList
                        .find { it.id == userId }
                        ?: userProfileList.first()
                )
            }
        }
    }
}

@Composable
private fun UserProfileDetailsCard(userProfileModel: UserProfileModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
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

// endregion USER PROFILE DETAILS

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun UserProfileDetailsPreview() {
    ComposeDemo1Theme {
        UserProfileDetailsScreen("user_1")
    }
}
