package com.challenge_lowes.forecast_app.domain.mappers

import com.challenge_lowes.forecast_app.data.remote.models.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class WeatherExtTest {
    @Test
    fun `mappingModelToDomainModelTest`() {
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

        //When
        val domainModel = server.mapToDomain("Colorado")

        //Then
        assertThat(domainModel.cityName).isEqualTo("Colorado")
        assertThat(domainModel.feelsLikeTemp).isEqualTo(15.0)
        assertThat(domainModel.maxTemp).isEqualTo(50.0)
        assertThat(domainModel.minTemp).isEqualTo(25.0)
        assertThat(domainModel.temp).isEqualTo(10.0)
        assertThat(domainModel.weatherDescription).isEqualTo("Rain")
        assertThat(domainModel.weatherName).isEqualTo("Rain")
    }
}