package com.udacity.asteroidradar.api

import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.dataBase.DatabasePictureOfDay
import retrofit2.http.GET
import retrofit2.http.Query

interface AsteroidApi {

    /*@GET("neo/rest/v1/feed?start_date=2022-05-25&end_date=2022-05-29&api_key=Wa0fS9OIhKOc7Zf9Ohb4UUuwHTBCUkN6FMmtnNX2")
        suspend fun getAsteroids(): String
    }*/

    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): String

    @GET("planetary/apod")
    suspend fun getImageOfTheDay(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): DatabasePictureOfDay
}

