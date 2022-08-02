package com.example.anda.ui.main.map

import android.view.View
import com.example.anda.databinding.ActivityMapViewBinding
import com.example.anda.ui.BaseActivity
import net.daum.mf.map.api.MapView

class FindOphthalmologyActivity: BaseActivity<ActivityMapViewBinding>(ActivityMapViewBinding::inflate), FindOphthalmologyView, View.OnClickListener {
    override fun initAfterBinding() {

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
    override fun onFindLoading() {
        binding.mapLoadingPb.visibility = View.VISIBLE
    }
    override fun onFindSuccess() {
        finish()
    }
    override fun onFindFailure(code: Int, message: String) {
        finish()
    }
}