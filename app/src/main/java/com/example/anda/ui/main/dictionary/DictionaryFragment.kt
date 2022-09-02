package com.example.anda.ui.main.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryBinding
import com.example.anda.ui.main.MainActivity


class DictionaryFragment():Fragment() {
    lateinit var binding: FragmentDictionaryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        binding.dictionarySymptomIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, SymptomFragment())
                .commitAllowingStateLoss()
        }
        binding.dictionaryOperationIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationFragment())
                .commitAllowingStateLoss()
        }
        binding.dictionaryPreventSideEffectIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, PreventSideEffectFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }
}
