package com.nearby.app.locations.repository

import com.nearby.app.base.network.NearByApiClient
import com.nearby.app.locations.datasource.NearByDataSource
import com.nearby.app.locations.entity.Repo
import io.reactivex.Observable

object NearByRemoteSource : NearByDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return NearByApiClient.getGithubSerivce().getStarredRepos(username)
    }


}