package com.example.anda.ui.find.pwd

import android.view.View
import com.example.anda.databinding.ActivityFindIdBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.pwd.model.FindpwdResponse

class FindpwdActivity:BaseActivity<ActivityFindIdBinding>(ActivityFindIdBinding::inflate),
    FindpwdView, View.OnClickListener{
    override fun initAfterBinding() {
        TODO("Not yet implemented")
    }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onFindpwdLoading() {
        TODO("Not yet implemented")
    }

    override fun onFindpwdSuccess(response: FindpwdResponse) {
        TODO("Not yet implemented")
    }

    override fun onFindpwdFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

}