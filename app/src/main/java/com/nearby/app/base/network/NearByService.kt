package com.nearby.app.base.network

import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NearByService {
    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user") username:String): Observable<List<NearBy>>
}