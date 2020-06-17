package com.mountmeru.network

import com.mine.weathercall.model.Weather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkCall {
    @GET(NetworkConstant.WEATHER)
    fun weatherCall(@Query("lat") latitude: Double, @Query("lon") longitude: Double): Call<Weather>
}