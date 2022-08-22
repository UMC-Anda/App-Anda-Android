package com.example.anda.ui.siginup.model

data class SignupRequestBody(
    var email:String,
    var password:String,
    var nickname:String,
    var recommendUserId:String
)
