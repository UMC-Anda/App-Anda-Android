package com.example.anda.ui.find.id

import com.example.anda.ui.find.id.model.FindIdResponse

interface FindIdView {
    fun onFindIdLoading()
    fun onFindIdSuccess(response: FindIdResponse)
    fun onFindIdFailure(code: Int, message: String)
}