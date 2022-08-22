package com.example.anda.ui.login


import com.example.anda.ui.login.model.LoginResponse


interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(response: LoginResponse)
    fun onLoginFailure(code: Int, message: String)
}