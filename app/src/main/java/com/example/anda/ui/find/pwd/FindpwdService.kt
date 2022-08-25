package com.example.anda.ui.find.pwd

import android.util.Log
import com.example.anda.config.Application
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.pwd.model.FindpwdRequestBody
import com.example.anda.ui.find.pwd.model.FindpwdResponse
import com.example.anda.ui.find.pwd.model.FindpwdRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindpwdService (var view: FindpwdView, private val userinfo : FindpwdRequestBody){
    fun tryFindpwd(){
        val retrofitInterface = Application.sRetrofit.create(FindpwdRetrofitInterface::class.java)
        retrofitInterface.postFindpwd(userinfo).enqueue(object : Callback<FindpwdResponse> {
            override fun onResponse(call: Call<FindpwdResponse>, response: Response<FindpwdResponse>){
                val resp : FindpwdResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onFindpwdSuccess(resp)
                    else -> view.onFindpwdFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<FindpwdResponse>, t: Throwable){
                Log.d("Login",t.toString())
                view.onFindpwdFailure(5001,t.message?:"로그인 통신 오류")
            }
        })

    }
}