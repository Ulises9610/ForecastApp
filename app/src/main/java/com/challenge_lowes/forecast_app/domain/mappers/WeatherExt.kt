package com.challenge_lowes.forecast_app.domain.mappers

import com.challenge_lowes.forecast_app.data.remote.models.ListResponse
import com.challenge_lowes.forecast_app.domain.models.WeatherView

fun ListResponse.mapToDomain(city: String): WeatherView = WeatherView(
    timeStamp = dataTimeCalculaiton,
    cityName = city,
    temp = main.temp,
    minTemp = main.tempMin,
    maxTemp = main.tempMax,
    feelsLikeTemp = main.feelsLike,
    weatherName = weather.firstOrNull()?.main ?: "",
    weatherDescription = weather.firstOrNull()?.description ?: ""
)