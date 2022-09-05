package com.example.anda.ui.main.dictionary.side_effect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionarySideEffectSmileBinding

class SideEffectSmile : Fragment() {
    lateinit var binding: FragmentDictionarySideEffectSmileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySideEffectSmileBinding.inflate(inflater, container, false)


        return binding.root

    }
}