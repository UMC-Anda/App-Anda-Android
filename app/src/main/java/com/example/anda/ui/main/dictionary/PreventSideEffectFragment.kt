package com.example.anda.ui.main.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentDictionaryPreventSideEffectBinding
import com.example.anda.ui.main.MainActivity

class PreventSideEffectFragment(): Fragment(){
    lateinit var binding: FragmentDictionaryPreventSideEffectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryPreventSideEffectBinding.inflate(inflater,container,false)


        return binding.root
    }
}