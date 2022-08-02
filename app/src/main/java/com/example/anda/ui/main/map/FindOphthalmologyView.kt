package com.example.anda.ui.main.map

interface FindOphthalmologyView {
    fun onFindLoading()
    fun onFindSuccess()
    fun onFindFailure(code:Int, message: String)
}