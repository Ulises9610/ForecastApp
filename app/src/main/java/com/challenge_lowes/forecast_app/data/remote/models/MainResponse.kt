package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainResponse(
    @SerializedName("temp") val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("pressure") val pressure: Int?,
    @SerializedName("sea_level") val seaLevel: Int?,
    @SerializedName("grnd_level") val grndLevel: Int?,
    @SerializedName("humidity") val humidity: Int?,
    @SerializedName("temp_kf") val tempKf: Double?
): Parcelable