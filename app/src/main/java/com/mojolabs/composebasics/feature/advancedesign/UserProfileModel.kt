package com.mojolabs.composebasics.feature.advancedesign

import com.mojolabs.composedemo1.R

data class UserProfileModel(
    val id: String,
    val photo: Int,
    // val photoUrl: String = "https://i.dummyjson.com/data/products/9/1.jpg",
    val photoUrl: String = "https://picsum.photos/200",
    val isOnline: Boolean,
    val name: String,
    val designation: String
)

val userProfileList =
    listOf(
        UserProfileModel(
            id = "user_1",
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            id = "user_2",
            photo = R.drawable.img_profile_2,
            isOnline = true,
            name = "Ashley Gordan",
            designation = "Software Engineer"
        ),
        UserProfileModel(
            id = "user_3",
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            id = "user_4",
            photo = R.drawable.img_profile_7,
            isOnline = true,
            name = "Cal Holly",
            designation = "Sales Manager"
        ),
        UserProfileModel(
            id = "user_5",
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            id = "user_6",
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            id = "user_7",
            photo = R.drawable.img_profile_2,
            isOnline = true,
            name = "Ashley Gordan",
            designation = "Software Engineer"
        ),
        UserProfileModel(
            id = "user_8",
            photo = R.drawable.img_profile_3,
            isOnline = true,
            name = "Martin Henry",
            designation = "Sr. Product Designer"
        ),
        UserProfileModel(
            id = "user_9",
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            id = "user_10",
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            id = "user_11",
            photo = R.drawable.img_profile_2,
            isOnline = true,
            name = "Ashley Gordan",
            designation = "Software Engineer"
        ),
        UserProfileModel(
            id = "user_12",
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            id = "user_13",
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            id = "user_14",
            photo = R.drawable.img_profile_4,
            isOnline = false,
            name = "Kate Perry",
            designation = "Mobile Engineer"
        ),
        UserProfileModel(
            id = "user_15",
            photo = R.drawable.img_profile_5,
            isOnline = false,
            name = "John Wick",
            designation = "Software Engineer"
        )
    )
