package com.example.anda.ui.find.pwd.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FindpwdRetrofitInterface {
    @POST("/app/users/find")
    fun postFindpwd(@Body userinfo : FindpwdRequestBody): Call<FindpwdResponse>

}