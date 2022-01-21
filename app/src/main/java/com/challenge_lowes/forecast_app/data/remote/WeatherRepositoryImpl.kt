package com.challenge_lowes.forecast_app.data.remote

import com.challenge_lowes.forecast_app.BuildConfig
import com.challenge_lowes.forecast_app.data.remote.models.WeatherResponse
import com.challenge_lowes.forecast_app.domain.repositories.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override suspend fun fetchWeather(cityName: String): WeatherResponse? {
        return weatherApi.getWeather(cityName, BuildConfig.API_KEY, BuildConfig.API_UNITS)
    }

}