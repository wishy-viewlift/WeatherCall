package com.mountmeru.db

import android.content.Context
import android.content.SharedPreferences
import com.mine.weathercall.R

class AppPreference(context: Context?) {
    private lateinit var prefs: SharedPreferences
    private val IS_LOGGED_IN = "IS_LOGGED_IN".toLowerCase()

    init {
        if (context != null) {
            prefs = context.getSharedPreferences(
                context.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
        }
    }

    fun isUserLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun setUserLoggedIn(loggedIn: Boolean) {
        prefs.edit().putBoolean(IS_LOGGED_IN, loggedIn).apply()
    }


}