package com.nearby.app.locations.datasource

import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable

interface NearByDataSource {
    fun fetchRepos(username:String) : Observable<List<NearBy>>
}