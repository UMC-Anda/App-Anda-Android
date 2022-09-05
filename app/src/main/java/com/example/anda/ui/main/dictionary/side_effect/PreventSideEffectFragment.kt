package com.example.anda.ui.main.dictionary.side_effect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryPreventSideEffectBinding
import com.example.anda.ui.main.MainActivity
import com.example.anda.ui.main.dictionary.operation.OperationLaserFragment

class PreventSideEffectFragment(): Fragment(){
    lateinit var binding: FragmentDictionaryPreventSideEffectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryPreventSideEffectBinding.inflate(inflater,container,false)

        settingSetOnClick()
        return binding.root
    }

    private fun settingSetOnClick() {
        //공통
        binding.dictionarySideEffectCommonCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SideEffectCommon())
                .commitAllowingStateLoss()
        }
        //라식
        binding.dictionarySideEffectLasikCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SideEffectLasik())
                .commitAllowingStateLoss()
        }
        //라섹
        binding.dictionarySideEffectLasekCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SideEffectLasek())
                .commitAllowingStateLoss()
        }
        //스마일
        binding.dictionarySideEffectSmileCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SideEffectSmile())
                .commitAllowingStateLoss()
        }
    }
}