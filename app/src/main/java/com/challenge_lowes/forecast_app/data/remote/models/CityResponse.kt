package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityResponse(
    @SerializedName("id") val id: String? =null,
    @SerializedName("name") val name: String = "",
    @SerializedName("coord") val coord: CoordResponse? = null,
    @SerializedName("country") val country: String? = null,
    @SerializedName("population") val population: Long? = null,
    @SerializedName("timezone") val timezone: Long? = null,
    @SerializedName("sunrise") val sunrise: Long? = null,
    @SerializedName("sunset") val sunset: Long? = null,
) : Parcelable