package com.challenge_lowes.forecast_app.data.remote

import com.challenge_lowes.forecast_app.data.remote.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeather(
        @Query("q") strCityName: String,
        @Query("appid") strUniqueApiKey: String,
        @Query("units") strUnits: String
    ): WeatherResponse?
}