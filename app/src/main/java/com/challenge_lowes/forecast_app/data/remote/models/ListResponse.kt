package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListResponse(
    @SerializedName("dt") val dataTimeCalculaiton: Long,
    @SerializedName("main") val main: MainResponse,
    @SerializedName("weather") val weather: List<PartialWeatherResponse>,
    @SerializedName("clouds") val clouds: CloudsResponse?,
    @SerializedName("wind") val wind: WindResponse?,
    @SerializedName("visibility") val visibility: Long?,
    @SerializedName("pop") val pop: Float?,
    @SerializedName("rain") val rain: RainResponse?,
    @SerializedName("sys") val sys: SysResponse?,
    @SerializedName("dt_txt") val dtText: String?

): Parcelable