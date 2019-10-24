package com.nearby.app.base.network

import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NearByService {
    // A request to search for nearby coffee shop recommendations via the Foursquare API.
    @GET("search/recommendations?v=20161101&intent=coffee")
    fun searchCoffee(
        @Query("client_id") clientID: String,
        @Query("client_secret") clientSecret: String,
        @Query("ll") ll: String,
        @Query("llAcc") llAcc: Double
    ): Observable<NearBy>
}