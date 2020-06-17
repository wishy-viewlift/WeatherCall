package com.mine.weathercall

import android.app.Application
import com.mvvm.livedata.di.networkModule
import com.mvvm.livedata.di.prefModule
import com.mvvm.livedata.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApp :Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApp)
            modules(listOf(prefModule,networkModule,viewModelModule))
        }
    }
}