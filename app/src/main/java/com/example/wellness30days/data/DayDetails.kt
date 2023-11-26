package com.example.wellness30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.wellness30days.R

data class DayDetails(
    var dayNumber: Int,
    @StringRes var dayHeader: Int,
    @StringRes var dayDescribtion: Int? = null,
    @DrawableRes var imageDetails: Int,
)

object DayDataSource {
    var listDays = mutableListOf(
        DayDetails(1, R.string.hero1, R.string.description1, R.drawable.android_superhero1),
        DayDetails(27, R.string.crafts, null, R.drawable.crafts),
        DayDetails(28, R.string.hero2, R.string.description2, R.drawable.android_superhero2),
        DayDetails(2, R.string.hero3, R.string.description3, R.drawable.android_superhero3),
        DayDetails(3, R.string.architecture, null, R.drawable.architecture),
        DayDetails(4, R.string.business,null, R.drawable.business),
        DayDetails(5, R.string.culinary, null, R.drawable.culinary),
        DayDetails(6, R.string.design, null, R.drawable.design),
        DayDetails(7, R.string.gaming, null, R.drawable.gaming),
        DayDetails(8, R.string.music, null, R.drawable.music),
        DayDetails(9, R.string.film, R.string.description1, R.drawable.android_superhero1),
        DayDetails(10, R.string.fashion, R.string.description1, R.drawable.android_superhero1),
        DayDetails(11, R.string.hero4, R.string.description4, R.drawable.android_superhero4),
        DayDetails(12, R.string.lifestyle, null, R.drawable.lifestyle),
        DayDetails(13, R.string.tech,null, R.drawable.tech),
        DayDetails(14, R.string.hero5, R.string.hero5, R.drawable.android_superhero5),
        DayDetails(15, R.string.hero6, R.string.description6, R.drawable.android_superhero6),
        DayDetails(16, R.string.drawing, null, R.drawable.drawing),
        DayDetails(17, R.string.painting, null, R.drawable.painting),
        DayDetails(18, R.string.photography, null, R.drawable.photography)
    )

}