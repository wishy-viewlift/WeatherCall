package com.mvvm.livedata.di

import com.mountmeru.viewmodel.WeatherViewModel
import org.koin.dsl.module

/**
 * Module for DI
 */
val viewModelModule = module {
    single { WeatherViewModel(get()) }
}