package com.nearby.app

import android.app.Application

class NearByApp : Application() {
    companion object {
        lateinit var  INSTANCE: NearByApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }




}