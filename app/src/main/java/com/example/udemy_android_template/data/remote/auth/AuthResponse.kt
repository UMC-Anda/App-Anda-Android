package com.example.udemy_android_template.data.remote.auth

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("email") val email: String,
    @SerializedName("AccessJWT") val AccessJWT: String,
    @SerializedName("RefreshJWT") val RefreshJWT: String
)

data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Auth?
)