package com.sopt.carrot.presentation.home

import androidx.annotation.DrawableRes

data class RecommendedJob(
    val id:Int,
    @DrawableRes val image: Int,
    val title: String,
    val salary: String
)
