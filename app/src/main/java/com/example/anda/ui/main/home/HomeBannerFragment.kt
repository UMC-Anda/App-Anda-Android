package com.example.anda.ui.main.home

import com.example.anda.databinding.FragmentHomeBannerBinding
import com.example.anda.ui.BaseFragment


class HomeBannerFragment(val imgRes : Int): BaseFragment<FragmentHomeBannerBinding>(FragmentHomeBannerBinding::inflate) {

    override fun initAfterBinding() {
        binding.homeBannerImageIv.setImageResource(imgRes)
    }


}