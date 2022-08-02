package com.example.anda.ui.main.map

import android.view.View
import com.example.anda.data.entities.MyLocation
import com.example.anda.data.entities.User
import com.example.anda.data.remote.auth.AuthService
import com.example.anda.databinding.ActivityMapViewBinding
import com.example.anda.databinding.ActivitySignupBinding
import com.example.anda.databinding.FragmentMapBinding
import com.example.anda.ui.BaseActivity
import com.example.anda.ui.BaseFragment
import com.example.anda.ui.siginup.SignUpView
import com.google.gson.annotations.SerializedName
import net.daum.mf.map.api.MapView


class FindOphthalmologyActivity: BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate) ,FindOphthalmologyView, View.OnClickListener {
    override fun initAfterBinding() {
        binding.findLocationButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v == null) return

        when(v) {
            binding.findLocationButton -> findOphthalmology()
        }
    }
    override fun onFindLoading() {
        //binding.mapLoadingPb.visibility = View.VISIBLE
    }
    override fun onFindSuccess() {
       // binding.mapLoadingPb.visibility = View.GONE
        binding.mapFragmentMaintext.text = "수신완료"
    }

    override fun onFindFailure(code: Int, message: String) {
        //finish()
    }


    private fun findOphthalmology(){
        binding.mapFragmentMaintext.text = "찾는중"
        val yCoordi = 0.0F
        val xCoordi = 0.0F
        val within = 0.0F
        val mylocation =  MyLocation(yCoordi, xCoordi, within)

        AuthService.findOphthalmology(this, mylocation)
    }
}

