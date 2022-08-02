package com.example.anda.ui.login


import com.example.anda.data.remote.auth.Result



interface LoginView {
    fun onLoginLoading()

    fun onLoginSuccess(code: Int, auth: Result)

    fun onLoginFailure(code: Int, message: String)
}