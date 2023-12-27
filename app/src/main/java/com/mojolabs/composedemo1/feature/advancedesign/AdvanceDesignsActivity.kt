package com.mojolabs.composedemo1.feature.advancedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mojolabs.composedemo1.ui.theme.ComposeDemo1Theme

class AdvanceDesignsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemo1Theme {
                UserProfileNavigator()
            }
        }
    }
}

@Composable
fun UserProfileNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "user_profile_list"
    ) {
        composable(route = "user_profile_list") {
            UserProfileListScreen(
                userProfileList = userProfileList,
                navController = navController
            )
        }
        composable(
            route = "user_profile_details/{user_id}",
            arguments = listOf(
                navArgument("user_id") {
                    type = NavType.StringType
                }
            )
        ) {
            UserProfileDetailsScreen(
                userId = it.arguments?.getString("user_id"),
                navController = navController
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun AdvanceDesignsPreview() {
    ComposeDemo1Theme {
        UserProfileNavigator()
    }
}
