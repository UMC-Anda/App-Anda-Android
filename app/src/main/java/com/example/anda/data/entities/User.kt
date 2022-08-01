package com.example.anda.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickName") val nickName: String,
//    @SerializedName("realName") val realName: String,
//    @SerializedName("phoneNumber") val phoneNumber: String,
//    @SerializedName("dateofBirth") val dateOfBirth: String,
    @SerializedName("recommander") val recommander: String?
)
