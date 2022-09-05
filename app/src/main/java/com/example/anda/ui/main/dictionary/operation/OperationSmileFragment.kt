package com.example.anda.ui.main.dictionary.operation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionaryOperationSmileBinding

class OperationSmileFragment: Fragment() {
    lateinit var binding : FragmentDictionaryOperationSmileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryOperationSmileBinding.inflate(inflater, container, false)


        return binding.root

    }
}