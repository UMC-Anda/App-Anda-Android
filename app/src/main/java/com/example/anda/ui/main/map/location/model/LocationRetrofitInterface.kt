package com.example.anda.ui.main.map.location.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LocationRetrofitInterface {
    @POST("/app/location")
    fun postLocation(@Body userinfo : LocationRequestBody): Call<LocationResponse>
}