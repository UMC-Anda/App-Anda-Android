package com.example.anda.ui.main.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryRecommendOphthalmologyBinding
import com.example.anda.ui.main.MainActivity

class RecommendOphthalmologyFragment(): Fragment(){
    lateinit var binding: FragmentDictionaryRecommendOphthalmologyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryRecommendOphthalmologyBinding.inflate(inflater,container,false)

        binding.recommendOphthalmologyBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, DictionaryFragment()).commitAllowingStateLoss()
        }
        return binding.root
    }
}