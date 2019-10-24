package com.nearby.app.locations.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nearby.app.locations.datasource.NearByDataSource
import com.nearby.app.locations.entity.NearBy
import com.nearby.app.utils.NetworkState
import com.nearby.app.utils.networkError
import io.reactivex.Observable

class NearByRepository(private val repoRemoteSource: NearByRemoteSource) :
    NearByDataSource {

    private val networkState: MutableLiveData<NetworkState> = MutableLiveData()
    private val errorState: MutableLiveData<String> = MutableLiveData()


    override fun fetchPlaces(clientId:String,clientSecret:String,ll:String,llAcc:Double): Observable<NearBy> {

        networkState.postValue(NetworkState.LOADING)

        return repoRemoteSource.fetchPlaces(clientId,clientSecret,ll,llAcc)
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