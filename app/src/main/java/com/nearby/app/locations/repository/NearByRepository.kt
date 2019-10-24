package com.nearby.app.locations.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nearby.app.locations.datasource.NearByDataSource
import com.nearby.app.locations.entity.Repo
import com.nearby.app.utils.NetworkState
import com.nearby.app.utils.networkError
import io.reactivex.Observable

class NearByRepository(private val repoRemoteSource: NearByRemoteSource) :
    NearByDataSource {

    private val networkState: MutableLiveData<NetworkState> = MutableLiveData()
    private val errorState: MutableLiveData<String> = MutableLiveData()


    override fun fetchRepos(username: String): Observable<List<Repo>> {

        networkState.postValue(NetworkState.LOADING)

        return repoRemoteSource.fetchRepos(username)
                        .doOnNext {

                            networkState.postValue(NetworkState.LOADED)
                        }.doOnError {
                            errorState.postValue(networkError(it))
                            networkState.postValue(NetworkState.ERROR)
                        }
                        .onErrorResumeNext(Observable.empty())



    }


    fun getMovieDetailsNetworkState(): LiveData <NetworkState> {
        return networkState
    }

    fun getError(): LiveData<String> {
        return errorState
    }



}