package com.example.udemy_android_template.ui.siginup

import android.view.View
import android.widget.Toast
import com.example.udemy_android_template.data.entities.User
import com.example.udemy_android_template.data.remote.auth.AuthResponse
import com.example.udemy_android_template.data.remote.auth.AuthRetrofitInterface
import com.example.udemy_android_template.data.remote.auth.AuthService
import com.example.udemy_android_template.data.remote.auth.getRetrofit
import com.example.udemy_android_template.databinding.ActivitySignupBinding
import com.example.udemy_android_template.ui.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity: BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate), SignUpView, View.OnClickListener {

    override fun initAfterBinding() {
        binding.signUpBackIv.setOnClickListener(this)
        binding.signUpSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {
            binding.signUpBackIv -> finish()
            binding.signUpSignUpBtn -> signUp()
        }
    }

    private fun getUser(): User {
        val email: String =
            binding.signUpIdEt.text.toString() + "@" + binding.signUpDirectInputEt.text.toString()
        val pwd: String = binding.signUpPasswordEt.text.toString()
        val nickName: String = binding.signUpNickNameEt.text.toString()
        val recommander: String? = binding.signUpRecommanderEt.text.toString()
//        val phoneNum: String = binding.signUpPhoneNumberEt.text.toString()
//        val realName: String = binding.signUpRealNameEt.text.toString()
//        val dateOfBirth: String = binding.signUpDateOfBirthEt.text.toString()

        return User(email, pwd, nickName, recommander)
    }

    private fun signUp() {
        if (binding.signUpIdEt.text.toString()
                .isEmpty() || binding.signUpDirectInputEt.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.signUpNickNameEt.text.toString().isEmpty()) {
            Toast.makeText(this, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString()) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        AuthService.signUp(this, getUser())
    }

    override fun onSignUpLoading() {
        binding.signUpLoadingPb.visibility = View.VISIBLE
    }

    override fun onSignUpSuccess() {
        binding.signUpLoadingPb.visibility = View.GONE

        finish()
    }

    override fun onSignUpFailure(code: Int, message: String) {
        binding.signUpLoadingPb.visibility = View.GONE

        when(code) {
            2016, 2017 -> {
                binding.signUpEmailErrorTv.visibility = View.VISIBLE
                binding.signUpEmailErrorTv.text = message
            }
        }
    }
}