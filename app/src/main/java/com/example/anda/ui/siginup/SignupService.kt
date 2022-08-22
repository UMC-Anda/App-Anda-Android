package com.example.anda.ui.siginup

import android.util.Log
import com.example.anda.config.Application
import com.example.anda.ui.siginup.model.SignupRequestBody
import com.example.anda.ui.siginup.model.SignupResponse
import com.example.anda.ui.siginup.model.SignupRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupService(var view: SignupView, private val userinfo : SignupRequestBody){
    fun trySignup(){
        val retrofitInterface = Application.sRetrofit.create(SignupRetrofitInterface::class.java)
        retrofitInterface.postSignup(userinfo).enqueue(object : Callback<SignupResponse>{
            override fun onResponse(call: Call<SignupResponse>, response: Response<SignupResponse>) {
                response.body()?.let { view.onSignUpSuccess(it) }
            }
            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Log.d("SignUp",t.toString())
                view.onSignUpFailure(5001,t.message?:"회원가입 통신 오류")
            }

        })
    }
}