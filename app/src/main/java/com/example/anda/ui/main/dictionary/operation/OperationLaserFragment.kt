package com.example.anda.ui.main.dictionary.operation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentDictionaryOperationLaserBinding

class OperationLaserFragment: Fragment(){
    lateinit var binding : FragmentDictionaryOperationLaserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDictionaryOperationLaserBinding.inflate(inflater,container,false)


        return binding.root

    }
}