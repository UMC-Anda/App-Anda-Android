package com.example.anda.ui.login

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.anda.databinding.ActivityLoginBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.find.id.FindIdActivity
import com.example.anda.ui.login.model.LoginRequestBody
import com.example.anda.ui.login.model.LoginResponse
import com.example.anda.ui.main.MainActivity
import com.example.anda.ui.siginup.SignupActivity

import com.example.anda.ui.login.LoginActivity
import com.example.anda.utils.saveJwt


class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginView, View.OnClickListener {

    override fun initAfterBinding() {
        setContentView(binding.root)
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtn.setOnClickListener(this)
        binding.loginFindIdTv.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {

            binding.loginSignUpTv -> startNextActivity(SignupActivity::class.java)
            binding.loginFindIdTv -> startNextActivity(FindIdActivity::class.java)
            binding.loginSignUpTv -> startNextActivity(LoginActivity::class.java)
            binding.loginSignInBtn -> login()
        }
    }

    private fun login() {
        if (binding.loginIdEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.loginPasswordEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val email = binding.loginIdEt.text.toString()
        val password = binding.loginPasswordEt.text.toString()
        val userinfo = LoginRequestBody(email, password)

        val service = LoginService(this, userinfo)
        service.tryLogin()
    }

    override fun onLoginLoading() {
        binding.loginLoadingPb.visibility = View.VISIBLE
    }


    override fun onLoginSuccess(response: LoginResponse) {
        binding.loginLoadingPb.visibility = View.GONE

//        saveJwt(response.result!!.aceessJWT)
//        saveJwt(response.result!!.refreshJWT)
        Log.d("로그인", "성공!")
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onLoginFailure(code: Int, message: String) {
        Log.d("로그인", "실패!")
        binding.loginLoadingPb.visibility = View.GONE
        binding.loginErrorTv.visibility = View.VISIBLE
        binding.loginErrorTv.text = message
    }
}