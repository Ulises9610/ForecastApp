package com.challenge_lowes.forecast_app.domain.repositories

import com.challenge_lowes.forecast_app.data.remote.models.WeatherResponse

interface WeatherRepository {
    suspend fun fetchWeather(cityName:String): WeatherResponse?
}