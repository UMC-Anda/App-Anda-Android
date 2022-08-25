package com.example.anda.ui.find.id

import android.view.View
import com.example.anda.databinding.ActivityFindIdBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.pwd.FindpwdActivity
import com.example.anda.ui.siginup.SignupActivity

class FindIdActivity:BaseActivity<ActivityFindIdBinding>(ActivityFindIdBinding::inflate),
    FindIdView, View.OnClickListener{
    override fun initAfterBinding() {
        setContentView(binding.root)
        binding.loginFindPwdTv.setOnClickListener(this)
        binding.findIdFindIdBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.loginFindPwdTv -> startNextActivity(FindpwdActivity::class.java)
            binding.loginFindPwdTv -> startNextActivity(FindIdActivity::class.java)
        }
    }

    override fun onFindIdLoading() {
        TODO("Not yet implemented")
    }

    override fun onFindIdSuccess(response: FindIdResponse) {
        TODO("Not yet implemented")
    }

    override fun onFindIdFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

}