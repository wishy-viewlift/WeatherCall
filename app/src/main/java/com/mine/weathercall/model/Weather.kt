package com.mine.weathercall.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Weather(
    @SerializedName("name")
    @Expose
    var cityName: String? = null,
    @SerializedName("main")
    @Expose
    var details: Details? = null

)