package com.nearby.app.locations.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nearby.app.R
import com.nearby.app.constant.CLIENT_ID
import com.nearby.app.constant.CLIENT_SECRET
import com.nearby.app.utils.NetworkState

class NearByActivity : AppCompatActivity() {

    //private lateinit var repoAdapter :GithubRepoAdapter
    private lateinit var nearByVM :NearByVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nearby)

       // val linearLayoutmg = LinearLayoutManager(applicationContext)
        //val divider = DividerItemDecoration(myStarsList.context, DividerItemDecoration.VERTICAL)
       // myStarsList.layoutManager = linearLayoutmg
       // repoAdapter = GithubRepoAdapter()
      //  myStarsList.adapter = repoAdapter
      //  myStarsList.addItemDecoration(divider)

        nearByVM = ViewModelProviders.of(this).get(NearByVM::class.java)

        nearByVM.networkState.observe(this, Observer {
          //  progressBar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            if(it==NetworkState.LOADING){
                Log.d("state","Loading")
            }else{
                Log.d("state","else")
            }
            //txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE

        })

        nearByVM.error.observe(this, Observer {
            Log.d("errorCode",it)
        })

        getStarredRepos(nearByVM)

        observeMyStars(nearByVM)

        //nearByVM.errorLiveData()
    }


    private fun getStarredRepos(viewModel :NearByVM){
        viewModel.getMyStarsRepos(CLIENT_ID, CLIENT_SECRET,"23423,23423",1.0)
    }

    private fun observeMyStars(viewModel:NearByVM){
        viewModel.getLiveData().observe(this, Observer {
               // repos -> repoAdapter.addRepos(ArrayList(repos))
        })
    }
}