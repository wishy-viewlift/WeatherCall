package com.mvvm.livedata.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.mountmeru.network.NetworkCall
import com.mountmeru.network.NetworkConstant
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module for DI
 */

val networkModule = module {
    factory { provideRetrofit() }
    single { provideNetworkApi(get()) }
}

/**
 * @return  Retrofit object for
 */
fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(NetworkConstant.BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
            )
        )
        .client(OkHttpClient.Builder().build())
        .build()

}


/**
 * @param retrofit - retrofit object for making API calls
 * @return  NetworkCall object which has all the API's listed
 */
fun provideNetworkApi(retrofit: Retrofit): NetworkCall =
    retrofit.create(NetworkCall::class.java)


