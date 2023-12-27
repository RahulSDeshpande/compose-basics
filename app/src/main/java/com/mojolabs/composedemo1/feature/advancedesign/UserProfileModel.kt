package com.mojolabs.composedemo1.feature.advancedesign

import com.mojolabs.composedemo1.R

data class UserProfileModel(
    val photo: Int,
    val photoUrl: String = "https://picsum.photos/200",
    // val photoUrl: String = "https://i.dummyjson.com/data/products/9/1.jpg",
    val isOnline: Boolean,
    val name: String,
    val designation: String
)

val userProfileList =
    listOf(
        UserProfileModel(
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_2,
            isOnline = true,
            name = "Ashley Gordan",
            designation = "Software Engineer"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_7,
            isOnline = true,
            name = "Cal Holly",
            designation = "Sales Manager"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_3,
            isOnline = true,
            name = "Martin Henry",
            designation = "Sr. Product Designer"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_1,
            isOnline = false,
            name = "John Doe",
            designation = "CEO"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_4,
            isOnline = false,
            name = "Kate Perry",
            designation = "Mobile Engineer"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_5,
            isOnline = false,
            name = "John Wick",
            designation = "Software Engineer"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_7,
            isOnline = true,
            name = "Cal Holly",
            designation = "Sales Manager"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_4,
            isOnline = false,
            name = "Kate Perry",
            designation = "Mobile Engineer"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_6,
            isOnline = true,
            name = "Tim Hortans",
            designation = "Intern"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_7,
            isOnline = true,
            name = "Cal Holly",
            designation = "Sales Manager"
        ),
        UserProfileModel(
            photo = R.drawable.img_profile_5,
            isOnline = false,
            name = "John Wick",
            designation = "Software Engineer"
        )
    )
