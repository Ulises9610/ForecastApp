package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherResponse(
    @SerializedName("cod") val id: String = "",
    @SerializedName("message") val message: Long?= null,
    @SerializedName("cnt") val aroundMessage: Long?= null,
    @SerializedName("list") val list: List<ListResponse>? = emptyList(),
    @SerializedName("city") val city: CityResponse = CityResponse(),
): Parcelable
