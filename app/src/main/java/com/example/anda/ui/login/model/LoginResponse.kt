package com.example.anda.ui.login.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result : Result?
)
data class Result(
    @SerializedName("email") var email : String?,
    @SerializedName("AccessJWT") var aceessJWT : String?,
    @SerializedName("RefreshJWT") var refreshJWT : String?
)