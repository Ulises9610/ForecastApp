package com.challenge_lowes.forecast_app.data.remote

import com.challenge_lowes.forecast_app.BuildConfig
import com.challenge_lowes.forecast_app.data.remote.models.*
import com.challenge_lowes.forecast_app.domain.repositories.WeatherRepository
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Test

class WeatherRepositoryImplTest {
    private val weatherApi: WeatherApi = mock()
    private val weatherRepository: WeatherRepository by lazy { WeatherRepositoryImpl(weatherApi) }

    @Test
    fun `givenApiExecuteGetWeatherToGetWeatherDataAndReturnCode200`()= runBlocking {
        //Given
        //Creation of mainServer
        val main = MainResponse(10.0,15.0,25.0,50.0,20,15,1,90,10.0)
        //Creation of partialWeatherServer
        val partial = PartialWeatherResponse("100","Rain","Rain","Icon")
        //Creation of clouds server
        val clouds = CloudsResponse(25.0f)
        //Creation of wind server
        val wind = WindResponse(15.0f,25.0f,23.0f)
        //Creation of rain server
        val rain = RainResponse(15.0f)
        //Creation of Sys server
        val sys = SysResponse("15.0")
        //Creation of ListServer
        val server = ListResponse(100,main, listOf(partial),clouds,wind,100,15.0f,rain,sys,"14.0")
        //Creation of coordinates server
        val coordinates = CoordResponse(10278828972.2,-145671122.0)
        //Creation of city server
        val city = CityResponse(id = "100", name = "Colorado",coordinates,"USA",23456765,45678,457876,3456789)
        val weatherServer = WeatherResponse(id = "200",
            message = 200,
            aroundMessage = 200,
            list = listOf(server),
            city = city)
        whenever(weatherApi.getWeather("Colorado", BuildConfig.API_KEY, "metric")).thenReturn(
            weatherServer)
        //When
        val response = weatherRepository.fetchWeather("Colorado")
        //Then
        assertThat(response?.id).isEqualTo("200")
        assertThat(response?.city?.name).isEqualTo("Colorado")
    }
}