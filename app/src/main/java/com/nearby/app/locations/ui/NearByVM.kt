package com.nearby.app.locations.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nearby.app.base.BaseVM
import com.nearby.app.locations.entity.NearBy
import com.nearby.app.locations.repository.NearByRemoteSource
import com.nearby.app.locations.repository.NearByRepository
import com.nearby.app.utils.NetworkState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NearByVM : BaseVM() {
    private val repoLiveData = MutableLiveData<List<NearBy>>()
    //private val errorLiveData = MutableLiveData<String>()
    private val repository = NearByRepository(NearByRemoteSource)

    fun getMyStarsRepos(username:String){
        if (repoLiveData.value !=null){
            return
        }

        addToDisposable(repository.fetchRepos(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    repoLiveData.value = it
                })
    }

    val networkState : LiveData<NetworkState> by lazy {
        repository.getMovieDetailsNetworkState()
    }

    val error : LiveData<String> by lazy {
        repository.getError()
    }


    fun getLiveData():LiveData<List<NearBy>> = repoLiveData
    //fun errorLiveData():LiveData<String> = errorLiveData

}















