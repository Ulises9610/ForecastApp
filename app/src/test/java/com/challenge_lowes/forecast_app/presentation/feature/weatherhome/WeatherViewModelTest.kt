package com.challenge_lowes.forecast_app.presentation.feature.weatherhome

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.challenge_lowes.forecast_app.data.remote.models.*
import com.challenge_lowes.forecast_app.domain.repositories.WeatherRepository
import com.challenge_lowes.forecast_app.utils.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.MockitoKotlinException
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private val viewModel: WeatherViewModel
    private val repository: WeatherRepository = mock()
    init {
        viewModel = WeatherViewModel(repository)
    }
    @Test
    fun `repositoryReturnsSuccessAndViewStateChangeToSuccess` () =
        //run blocking is used because I'm working with coroutines.
        runBlocking {
            //Given
            //Creation of mainServer
            val main = MainResponse(10.0,15.0,25.0,50.0,20,15,1,90,10.0)
            //Creation of partialWeatherServer
            val partial = PartialWeatherResponse("100","150","Rain","Icon")
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
            val weatherServer = WeatherResponse(id = "1000",
            message = 500,
            aroundMessage = 250,
            list = listOf(server),
            city = city)
            whenever(repository.fetchWeather(any())).thenReturn(weatherServer)
            //When
            viewModel.getWeather("Colorado")
            //Then
            val loadingState = viewModel.data.getOrAwaitValueTest()
            assertThat(loadingState).isInstanceOf(WeatherViewState.Loading::class.java)

            val success = viewModel.data.getOrAwaitValueTest()
            assertThat(success).isInstanceOf(WeatherViewState.Success::class.java)

            val cityName = (success as WeatherViewState.Success).data?.get(0)?.cityName
            assertThat(cityName).isEqualTo("Colorado")
        }
    @Test
    fun `repositoryReturnsExceptionAndViewStateChangeToError`() =
        runBlocking {
        //Given
        whenever(repository.fetchWeather(any())).thenThrow(
            MockitoKotlinException("Error",
            Exception())
        )

        //When
        viewModel.getWeather("Colorado")

        //Then
        val viewStateLoading = viewModel.data.getOrAwaitValueTest()
        assertThat(viewStateLoading).isInstanceOf(WeatherViewState.Loading::class.java)

        val viewState = viewModel.data.getOrAwaitValueTest()
        assertThat(viewState).isInstanceOf(WeatherViewState.Error::class.java)
    }
    @Test
    fun `restDataToChangeViewStateToNull`() {
        //Given
        //When
        viewModel.resetData()

        //Then
        val viewState = viewModel.data.getOrAwaitValueTest()
        assertThat(viewState).isNull()
    }
}