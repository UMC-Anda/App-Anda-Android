package com.example.anda.ui.siginup.model

import com.google.gson.annotations.SerializedName

data class SignupResponse (
    @SerializedName("isSuccess")
    var isSuccess : Boolean?,
    @SerializedName("code")
    var code : Int?,
    @SerializedName("message")
    var message : String?,
    @SerializedName("result")
    var result : Result?,
)
data class Result(
    @SerializedName("email")
    var email : String?
)
