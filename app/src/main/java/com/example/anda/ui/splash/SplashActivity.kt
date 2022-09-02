package com.example.anda.ui.splash

import android.os.Handler
import android.os.Looper
import com.example.anda.R
import com.example.anda.databinding.ActivitySplashBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.login.LoginActivity
import com.example.anda.ui.main.MainActivity


class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate), SplashView {

    override fun initAfterBinding() {
        //자동 로그인 코드
        /*Handler(Looper.getMainLooper()).postDelayed({
            autoLogin()
        }, 2000)*/
        splashAnim()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivityWithClear(LoginActivity::class.java)
        }, 3000)
    }

    private fun splashAnim(){
        Handler(Looper.getMainLooper()).postDelayed({
            binding.splashDefaultIv.setImageResource(R.drawable.splash)
        }, 3000)

    }
    private fun autoLogin() {
//        AuthService.autoLogin(this)
    }

    override fun onAutoLoginLoading() {

    }

    override fun onAutoLoginSuccess() {
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onAutoLoginFailure(code: Int, message: String) {
        startActivityWithClear(LoginActivity::class.java)
    }
}