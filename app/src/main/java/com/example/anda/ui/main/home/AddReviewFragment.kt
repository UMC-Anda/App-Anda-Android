package com.example.anda.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentHomeAddReviewBinding

class AddReviewFragment: Fragment() {
    lateinit var binding: FragmentHomeAddReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAddReviewBinding.inflate(inflater, container, false)

        return binding.root
    }
}
