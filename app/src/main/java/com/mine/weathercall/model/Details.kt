package com.mine.weathercall.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Details(
    @SerializedName("temp_min")
    @Expose
    var minTemp: Double,
    @SerializedName("temp_max")
    @Expose
    var maxTemp: Double,
    @SerializedName("pressure")
    @Expose
    var pressure: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double

)