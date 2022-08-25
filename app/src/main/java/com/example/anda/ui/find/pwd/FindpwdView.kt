package com.example.anda.ui.find.pwd

import com.example.anda.ui.find.pwd.model.FindpwdResponse

interface FindpwdView {
    fun onFindpwdLoading()
    fun onFindpwdSuccess(response: FindpwdResponse)
    fun onFindpwdFailure(code: Int, message: String)
}