package com.example.anda.ui.main.dictionary.side_effect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionarySideEffectLasekBinding

class SideEffectLasek : Fragment() {
    lateinit var binding: FragmentDictionarySideEffectLasekBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySideEffectLasekBinding.inflate(inflater, container, false)


        return binding.root

    }
}