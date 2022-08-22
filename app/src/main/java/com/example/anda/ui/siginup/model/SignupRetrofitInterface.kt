package com.example.anda.ui.siginup.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupRetrofitInterface {
    @POST("/app/users/signup")
    fun postSignup(@Body userinfo : SignupRequestBody):Call<SignupResponse>

}