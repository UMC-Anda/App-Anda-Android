package com.example.anda.ui.siginup

import com.example.anda.ui.siginup.model.SignupResponse

interface SignupView {
    fun onSignUpLoading()
    fun onSignUpSuccess(response: SignupResponse)
    fun onSignUpFailure(code: Int, message: String)
}
