package com.example.anda.data.remote.auth

import com.example.anda.data.entities.MyLocation
import com.example.anda.data.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthRetrofitInterface {

    @POST("/users/signup")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("/users/signin")
    fun login(@Body user: User): Call<AuthResponse>


    @GET("/users/auto-login")
    fun autoLogin(): Call<AuthResponse>
    
    @POST("/location/127.033311/37.5611326/5")
    fun findOphthalmology(@Body myLocation: MyLocation): Call<AuthResponse>
}