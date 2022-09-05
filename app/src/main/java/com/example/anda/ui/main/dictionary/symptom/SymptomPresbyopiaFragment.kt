package com.example.anda.ui.main.dictionary.symptom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionarySymptomPresbyopiaBinding

class SymptomPresbyopiaFragment : Fragment() {
    lateinit var binding: FragmentDictionarySymptomPresbyopiaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionarySymptomPresbyopiaBinding.inflate(inflater, container, false)


        return binding.root

    }
}