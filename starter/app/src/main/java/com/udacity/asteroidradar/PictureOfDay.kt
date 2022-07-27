package com.udacity.asteroidradar

data class PictureOfDay(
    val date: String,
    //@Json(name = "media_type") val mediaType: String,
    val title: String,
    val url: String
) {
    override fun toString(): String {
        return "PictureOfDay(date='$date', title='$title', url='$url')"
    }
}