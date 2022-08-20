package com.example.anda.ui.siginup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anda.data.entities.User
//import com.example.anda.data.remote.auth.AuthService
import com.example.anda.databinding.ActivitySignupBinding
import com.example.anda.ui.siginup.model.SignUpRequestBody
import com.example.anda.ui.siginup.model.SignupResponse
import java.lang.NullPointerException


class SignUpActivity: AppCompatActivity(), SignUpView, View.OnClickListener {
    lateinit var binding : ActivitySignupBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpBackIv.setOnClickListener(this)
        binding.signUpSignUpBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.signUpBackIv -> finish()
            binding.signUpSignUpBtn -> signUp()
        }
    }

    private fun signUp() {
        //붉은 에러 메시지
        if (binding.signUpIdEt.text.toString().isEmpty()) {
            binding.signUpIdUnderscoreView.visibility = View.GONE
            binding.signUpEmailErrorTv.visibility = View.VISIBLE
            binding.signUpEmailErrorTv.text = "이메일을 입력해주세요"
        }
        if (binding.signUpPasswordEt.text.toString().isEmpty()) {
            binding.signUpPasswordUnderscoreView.visibility = View.GONE
            binding.signUpPasswordErrorTv.visibility = View.VISIBLE
            binding.signUpPasswordErrorTv.text = "비밀번호를 입력해주세요"
        }
        if (binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString()) {
            binding.signUpPasswordCheckUnderscoreView.visibility = View.GONE
            binding.signUpPasswordCheckErrorTv.visibility = View.VISIBLE
            binding.signUpPasswordCheckErrorTv.text = "비밀번호가 일치하지 않습니다"
        }
        if (binding.signUpNickNameEt.text.toString().isEmpty()) {
            binding.signUpNicknameUnderscoreView.visibility = View.GONE
            binding.signUpNicknameErrorTv.visibility = View.VISIBLE
            binding.signUpNicknameErrorTv.text = "다른 닉네임을 사용해주세요"
        }

        //토스트
        if (binding.signUpIdEt.text.toString().isEmpty()
            || binding.signUpDirectInputEt.text.toString().isEmpty()
        ) {
            Toast.makeText(this, "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.signUpPasswordEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString()) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.signUpNickNameEt.text.toString().isEmpty()) {
            Toast.makeText(this, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }
        val email: String =
            binding.signUpIdEt.text.toString() + "@" + binding.signUpDirectInputEt.text.toString()
        val pwd: String = binding.signUpPasswordEt.text.toString()
        val nickName: String = binding.signUpNickNameEt.text.toString()
        val recommendUserId: String
        if(binding.signUpRecommanderEt.text.isEmpty()){
            recommendUserId = "null"
        }
        else{
            recommendUserId = binding.signUpRecommanderEt.text.toString()
        }

        val userinfo = SignUpRequestBody(email,pwd,nickName,recommendUserId)


        val service = SignupService(this, userinfo)
        service.trySignup()
    }


    override fun onSignUpSuccess(response: SignupResponse) {
        Log.d("회원가입","성공!")
    }

    override fun onSignUpFailure(code: Int, message: String) {
        binding.signUpLoadingPb.visibility = View.GONE
        binding.signUpEmailErrorTv.visibility = View.VISIBLE
        binding.signUpEmailErrorTv.text = message
    }
}
