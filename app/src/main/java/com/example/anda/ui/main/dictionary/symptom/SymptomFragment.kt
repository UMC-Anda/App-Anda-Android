package com.example.anda.ui.main.dictionary.symptom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionarySymptomBinding
import com.example.anda.ui.main.MainActivity

class SymptomFragment(): Fragment(){
    lateinit var binding: FragmentDictionarySymptomBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySymptomBinding.inflate(inflater, container, false)

        settingSetOnClick()
        return binding.root
    }

    private fun settingSetOnClick() {
        //근시
        binding.dictionarySymptomNearsightedCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SymptomNearsightedFragment())
                .commitAllowingStateLoss()
        }
        //난시
        binding.dictionarySymptomAstigmatismCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SymptomAstigmatismFragment())
                .commitAllowingStateLoss()
        }
        //원시
        binding.dictionarySymptomFarsightedCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SymptomFarsightedFragment())
                .commitAllowingStateLoss()
        }
        //노안
        binding.dictionarySymptomPresbyopiaCategoryIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SymptomPresbyopiaFragment())
                .commitAllowingStateLoss()
        }
    }
}