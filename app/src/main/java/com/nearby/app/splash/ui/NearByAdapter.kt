package com.nearby.app.splash.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nearby.app.locations.entity.NearBy

class NearByAdapter (private val nearByList: ArrayList<NearBy>) : RecyclerView.Adapter<NearByAdapter.NearByViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearByViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(0, parent, false)

        return NearByViewHolder(view)
    }

    override fun getItemCount(): Int {

        return nearByList.size
    }

    override fun onBindViewHolder(holder: NearByViewHolder, position: Int) {

        holder.bind(nearByList)
    }


    class NearByViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){


        fun bind(nearByList: ArrayList<NearBy>){

        }
    }
}