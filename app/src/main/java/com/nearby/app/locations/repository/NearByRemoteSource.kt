package com.nearby.app.locations.repository

import com.nearby.app.base.network.NearByApiClient
import com.nearby.app.locations.datasource.NearByDataSource
import com.nearby.app.locations.entity.NearBy
import io.reactivex.Observable

object NearByRemoteSource : NearByDataSource {
    override fun fetchRepos(username: String): Observable<List<NearBy>> {
        return NearByApiClient.getNearByService().getStarredRepos(username)
    }


}