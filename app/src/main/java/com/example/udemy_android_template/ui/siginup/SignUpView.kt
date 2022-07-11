package com.example.udemy_android_template.ui.siginup

import retrofit2.http.POST

interface SignUpView {
    fun onSignUpLoading()
    fun onSignUpSuccess()
    fun onSignUpFailure(code: Int, message: String)

}
