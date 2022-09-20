package com.example.anda.ui.find.id

import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.anda.databinding.ActivityFindIdBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.find.id.model.FindIdResponse
import com.example.anda.ui.find.pwd.FindpwdActivity
import com.example.anda.ui.login.LoginActivity
import com.example.anda.ui.siginup.SignupActivity

class FindIdActivity:BaseActivity<ActivityFindIdBinding>(ActivityFindIdBinding::inflate), View.OnClickListener{
    override fun initAfterBinding() {
        setContentView(binding.root)
        binding.findIdFindPwdTv.setOnClickListener(this)
        binding.findIdBackIv.setOnClickListener(this)
        binding.findIdFindIdBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.findIdFindPwdTv -> startNextActivity(FindpwdActivity::class.java)
            binding.findIdBackIv -> startNextActivity(LoginActivity::class.java)
            binding.findIdFindIdBtn -> showId()
        }
    }
    private fun showId() {
        binding.findIdShowIdIv.visibility = View.VISIBLE
        binding.findIdShowIdEt.visibility = View.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            binding.findIdShowIdIv.visibility = View.GONE
            binding.findIdShowIdEt.visibility = View.GONE
        }, 3000)
    }
}