package com.challenge_lowes.forecast_app.core.di

import com.challenge_lowes.forecast_app.data.remote.WeatherApi
import com.challenge_lowes.forecast_app.data.remote.WeatherRepositoryImpl
import com.challenge_lowes.forecast_app.domain.repositories.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providesWeatherRepository(weatherApi: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(weatherApi)
}