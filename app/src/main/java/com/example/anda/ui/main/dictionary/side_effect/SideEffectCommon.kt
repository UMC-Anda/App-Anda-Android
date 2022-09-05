package com.example.anda.ui.main.dictionary.side_effect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionarySideEffectCommonBinding

class SideEffectCommon : Fragment() {
    lateinit var binding: FragmentDictionarySideEffectCommonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySideEffectCommonBinding.inflate(inflater, container, false)


        return binding.root

    }
}