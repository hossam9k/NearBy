package com.nearby.app.locations.datasource

import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable

interface NearByDataSource {
    fun fetchPlaces(clientId:String,clientSecret:String,ll:String,llAcc:Double) : Observable<NearBy>
}