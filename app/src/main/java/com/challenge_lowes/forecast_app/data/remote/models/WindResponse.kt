package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WindResponse(
    @SerializedName("speed") val speed: Float?,
    @SerializedName("deg") val deg: Float?,
    @SerializedName("gust") val gust: Float?,
) : Parcelable