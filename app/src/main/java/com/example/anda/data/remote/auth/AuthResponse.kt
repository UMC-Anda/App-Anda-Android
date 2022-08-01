package com.example.anda.data.remote.auth

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("cityname") val cityname: String,
    @SerializedName("townname") val townname: String,
    @SerializedName("postcode") val postcode: Int,
    @SerializedName("address") val address: String,
    @SerializedName("phonenumber") val phonenumber: String,
    @SerializedName("url") val url: String,
    @SerializedName("xCooordi") val xCooordi: Float,
    @SerializedName("yCooordi") val yCooordi: Float,
    @SerializedName("distance") val distance: Float,
    @SerializedName("jwt") val jwt: String
    )

data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Result?
)