package com.example.anda.ui.find.id.model

import com.example.anda.ui.login.model.Result
import com.google.gson.annotations.SerializedName

data class FindIdResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result : Result?
)
data class Result(
    @SerializedName("email") var email : String?
)
