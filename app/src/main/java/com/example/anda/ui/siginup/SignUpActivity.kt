package com.example.anda.ui.siginup

import android.view.View
import android.widget.Toast
import com.example.anda.data.entities.User
import com.example.anda.data.remote.auth.AuthService
import com.example.anda.databinding.ActivitySignupBinding
import com.example.anda.ui.BaseActivity


class SignUpActivity: BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate), SignUpView, View.OnClickListener {

    override fun initAfterBinding() {
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

    private fun getUser(): User {
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
//        val phoneNum: String = binding.signUpPhoneNumberEt.text.toString()
//        val realName: String = binding.signUpRealNameEt.text.toString()
//        val dateOfBirth: String = binding.signUpDateOfBirthEt.text.toString()
        return User(email, pwd, nickName, recommendUserId)
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
        binding.signUpEmailErrorTv.visibility = View.VISIBLE
        binding.signUpEmailErrorTv.text = message
    }
}
