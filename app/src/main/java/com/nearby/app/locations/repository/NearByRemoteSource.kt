package com.nearby.app.locations.repository

import com.nearby.app.base.network.NearByApiClient
import com.nearby.app.locations.datasource.NearByDataSource
import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable

object NearByRemoteSource : NearByDataSource {
    override fun fetchPlaces(clientId:String,clientSecret:String,ll:String,llAcc:Double): Observable<NearBy> {
        return NearByApiClient.getNearByService().searchCoffee(clientId,clientSecret,ll,llAcc)
    }


}