package com.example.anda.ui.find.id.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface FindIdRetrofitInterface {
    @POST("/app/users/find")
    fun postFindId(@Body userinfo : FindIdRequestBody): Call<FindIdResponse>

}