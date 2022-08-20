package com.example.anda.ui.siginup

import com.example.anda.ui.siginup.model.SignupResponse

interface SignUpView {
//    fun onSignUpLoading()
    fun onSignUpSuccess(response: SignupResponse)
    fun onSignUpFailure(code: Int, message: String)
}
