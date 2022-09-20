package com.example.anda.ui.find.pwd

import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.anda.databinding.ActivityFindIdBinding
import com.example.anda.databinding.ActivityFindPwdBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.pwd.model.FindpwdResponse
import com.example.anda.ui.login.LoginActivity

class FindpwdActivity:BaseActivity<ActivityFindPwdBinding>(ActivityFindPwdBinding::inflate), View.OnClickListener{
    override fun initAfterBinding() {
        setContentView(binding.root)
        binding.findPwdFindPwdBtn.setOnClickListener(this)
        binding.findPwdBackIv.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.findPwdFindPwdBtn -> showPwd()
            binding.findPwdBackIv -> finish()
        }
}

    private fun showPwd() {
        binding.findPwdShowPwdIv.visibility = View.VISIBLE
        binding.findPwdShowPwdEt.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            binding.findPwdShowPwdIv.visibility = View.GONE
            binding.findPwdShowPwdEt.visibility = View.GONE
        }, 3000)
    }
}
