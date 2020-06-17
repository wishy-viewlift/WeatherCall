package com.mountmeru.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mine.weathercall.model.Weather
import com.mine.weathercall.viewmodel.SingleLiveEvent
import com.mountmeru.network.NetworkCall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherViewModel(networkCall: NetworkCall) : ViewModel(),
    Callback<Weather> {
    var progressDialog: SingleLiveEvent<Boolean>? = null
    var apiResponse: MutableLiveData<Weather>? = null
    var networkCall: NetworkCall;

    init {
        progressDialog = SingleLiveEvent<Boolean>()
        apiResponse = MutableLiveData<Weather>()
        this.networkCall = networkCall
    }

    fun fetchWeather(latitude: Double, longitude: Double) {
        progressDialog?.value = true
        networkCall.weatherCall(latitude, longitude).enqueue(this)

    }

    override fun onFailure(call: Call<Weather>, t: Throwable) {
        progressDialog?.value = false
    }

    override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
        progressDialog?.value = false
        apiResponse?.value = response?.body()
    }


}