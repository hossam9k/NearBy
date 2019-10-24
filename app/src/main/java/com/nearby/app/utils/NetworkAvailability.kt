@file:Suppress("DEPRECATION")

package com.nearby.app.utils

import android.content.Context
import android.net.ConnectivityManager

fun Context.isNetworkStatusAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    connectivityManager?.let { it ->
        it.activeNetworkInfo?.let {
            if (it.isConnected) return true
        }
    }
    return false
}