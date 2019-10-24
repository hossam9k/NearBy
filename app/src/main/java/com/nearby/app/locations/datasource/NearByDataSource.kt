package com.nearby.app.locations.datasource

import com.nearby.app.locations.entity.Repo
import io.reactivex.Observable

interface NearByDataSource {
    fun fetchRepos(username:String) : Observable<List<Repo>>
}