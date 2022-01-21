package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PartialWeatherResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("main") val main: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("icon") val icon: String?,
): Parcelable