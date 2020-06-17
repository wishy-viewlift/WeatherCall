package com.mvvm.livedata.di

import com.mountmeru.db.AppPreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Module for DI
 */
val prefModule = module {
    single { AppPreference(androidContext()) }
}