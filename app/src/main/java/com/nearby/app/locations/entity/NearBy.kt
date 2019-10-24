package com.nearby.app.locations.entity


import com.google.gson.annotations.SerializedName



data class NearBy (
                 @SerializedName("id")  val id:String,
                 @SerializedName("name")  val name:String,
                 @SerializedName("description") val desc:String?,
                 @SerializedName("language") val lang:String?,
                 @SerializedName("stargazers_count") val starCount:Int
)