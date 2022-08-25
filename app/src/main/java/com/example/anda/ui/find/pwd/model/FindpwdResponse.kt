package com.example.anda.ui.find.pwd.model

import com.example.anda.ui.login.model.Result
import com.google.gson.annotations.SerializedName

data class FindpwdResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?
)
