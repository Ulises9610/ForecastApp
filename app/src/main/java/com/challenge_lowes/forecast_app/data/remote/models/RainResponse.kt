package com.challenge_lowes.forecast_app.data.remote.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RainResponse(
    @SerializedName("3h") val threeH: Float?,
): Parcelable