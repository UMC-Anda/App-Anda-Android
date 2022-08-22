package com.example.anda.ui.main.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionarySymptomBinding
import com.example.anda.ui.BaseFragment
import com.example.anda.ui.main.MainActivity

class SymptomFragment(): Fragment(){
    lateinit var binding: FragmentDictionarySymptomBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySymptomBinding.inflate(inflater, container, false)

        binding.symptomBackIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, DictionaryFragment()).commitAllowingStateLoss()
        }
        return binding.root
    }
}