package com.example.anda.ui.main.map.location.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result : Result?
)
data class Result(
    @SerializedName("name") var name : String?,
    @SerializedName("cityname") var cityname : String?,
    @SerializedName("townname") var townname : String?,
    @SerializedName("postcode") var postcode : Int?,
    @SerializedName("address") var address : String?,
    @SerializedName("phonenumber") var phonenumber : String?,
    @SerializedName("url") var url : String?,
    @SerializedName("xCoordi") var xCoordi : Float?,
    @SerializedName("yCoordi") var yCoordi : Float?,
    @SerializedName("distance") var distance : Float?
)