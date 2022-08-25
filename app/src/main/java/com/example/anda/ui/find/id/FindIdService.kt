package com.example.anda.ui.find.id

import android.util.Log
import com.example.anda.config.Application
import com.example.anda.ui.find.id.model.FindIdRequestBody
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.id.model.FindIdRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindIdService (var view: FindIdView, private val userinfo : FindIdRequestBody){
    fun tryFindId(){
        val retrofitInterface = Application.sRetrofit.create(FindIdRetrofitInterface::class.java)
        retrofitInterface.postFindId(userinfo).enqueue(object : Callback<FindIdResponse> {
            override fun onResponse(call: Call<FindIdResponse>, response: Response<FindIdResponse>){
                val resp : FindIdResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onFindIdSuccess(resp)
                    else -> view.onFindIdFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<FindIdResponse>, t: Throwable){
                Log.d("Login",t.toString())
                view.onFindIdFailure(5001,t.message?:"로그인 통신 오류")
            }
        })

    }
}