package com.example.anda.ui.main.dictionary.operation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryOperationBinding
import com.example.anda.ui.main.MainActivity

class OperationFragment(): Fragment(){
    lateinit var binding : FragmentDictionaryOperationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryOperationBinding.inflate(inflater,container,false)

        settingSetOnClick()
        return binding.root

    }

    private fun settingSetOnClick() {
        //레이저
        binding.dictionaryOperationLaserCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationLaserFragment())
                .commitAllowingStateLoss()
        }
        //라식
        binding.dictionaryOperationLasikCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationLasikFragment())
                .commitAllowingStateLoss()
        }
        //라섹
        binding.dictionaryOperationLasekCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationLasekFragment())
                .commitAllowingStateLoss()
        }
        //스마일 라식
        binding.dictionaryOperationSmileCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationSmileFragment())
                .commitAllowingStateLoss()
        }
        //렌즈삽입술
        binding.dictionaryOperationLensCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationLensFragment())
                .commitAllowingStateLoss()
        }
    }

}