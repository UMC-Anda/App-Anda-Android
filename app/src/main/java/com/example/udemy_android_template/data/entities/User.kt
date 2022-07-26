package com.example.udemy_android_template.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("nickName") val nickName: String,
    @SerializedName("recommendUserId") val recommander: String?
)
