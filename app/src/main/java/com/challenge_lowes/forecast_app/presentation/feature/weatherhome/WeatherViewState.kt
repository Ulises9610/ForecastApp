package com.challenge_lowes.forecast_app.presentation.feature.weatherhome

import com.challenge_lowes.forecast_app.domain.models.WeatherView

sealed class WeatherViewState(
) {
    class Success(val data: List<WeatherView>?) : WeatherViewState()
    class Error(val message: String?) : WeatherViewState()
    class Loading : WeatherViewState()
}