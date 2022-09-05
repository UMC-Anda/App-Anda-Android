package com.example.anda.ui.main.dictionary.symptom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionarySymptomFarsightedBinding

class SymptomFarsightedFragment : Fragment() {
    lateinit var binding: FragmentDictionarySymptomFarsightedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySymptomFarsightedBinding.inflate(inflater, container, false)


        return binding.root

    }
}