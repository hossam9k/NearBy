package com.nearby.app.utils

import retrofit2.HttpException
import java.io.IOException

 fun networkError(ex:Throwable): String? {

    return when (ex) {
        is IOException -> ex.message.toString()
        is HttpException -> ex.code().toString()
        else -> ex.message.toString()
    }

}