package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoordResponse(
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lon") val lon: Double?
) : Parcelable