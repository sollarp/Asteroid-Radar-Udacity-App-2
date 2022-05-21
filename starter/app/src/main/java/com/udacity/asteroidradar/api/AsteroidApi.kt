package com.udacity.asteroidradar.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.PictureOfDay
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import kotlin.reflect.jvm.internal.impl.load.java.Constant

interface AsteroidApi {

        @GET("neo/rest/v1/feed?start_date=2022-05-15&end_date=2022-05-21&api_key=Wa0fS9OIhKOc7Zf9Ohb4UUuwHTBCUkN6FMmtnNX2")
        suspend fun getAsteroids(): String
    }

    /*@GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
    @Query("start_date") startDate: String,
    @Query("end_date") endDate: String,
    @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<List<Asteroid>>

    @GET("planetary/apod")
    fun getImageOfTheDay(): Deferred<PictureOfDay>
*/

