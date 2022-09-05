//package com.example.anda.ui.main.map.location
//
//import android.location.Location
//import android.util.Log
//import com.example.anda.config.Application
//import com.example.anda.ui.login.LoginView
//import com.example.anda.ui.login.model.LoginRequestBody
//import com.example.anda.ui.login.model.LoginResponse
//import com.example.anda.ui.login.model.LoginRetrofitInterface
//import com.example.anda.ui.main.map.location.model.LocationRequestBody
//import com.example.anda.ui.main.map.location.model.LocationResponse
//import com.example.anda.ui.main.map.location.model.LocationRetrofitInterface
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class LocationService (var view: LocationView, private val userinfo : LocationRequestBody){
//    fun tryLocation(){
//        val retrofitInterface = Application.sRetrofit.create(LocationRetrofitInterface::class.java)
//        retrofitInterface.postLocation(userinfo).enqueue(object : Callback<LocationResponse> {
//            override fun onResponse(call: Call<LocationResponse>, response: Response<LocationResponse>){
//                val resp : LocationResponse = response.body()!!
//                when(val code = resp.code){
//                    1000 -> view.onLocationSuccess(resp)
//                    else -> view.onLocationFailure(code!!, resp.message!!)
//                }
//            }
//            override fun onFailure(call: Call<LocationResponse>, t: Throwable){
//                Log.d("Login",t.toString())
//                view.onLocationFailure(5001,t.message?:"로그인 통신 오류")
//            }
//        })
//
//    }
//}