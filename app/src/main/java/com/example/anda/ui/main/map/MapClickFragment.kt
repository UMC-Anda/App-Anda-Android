package com.example.anda.ui.main.map

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.anda.R
import com.example.anda.databinding.FragmentMapBinding
import com.example.anda.ui.main.MainActivity
import com.example.anda.ui.main.dictionary.operation.OperationFragment
import com.example.anda.ui.main.dictionary.symptom.SymptomFragment

class MapClickFragment (): Fragment() {
    lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        settingSetOnClick()

        return binding.root
    }

        private fun settingSetOnClick() {
            //라섹

            //라식

            //스마일 라식
            val imgResId = R.drawable.map_smile_default_btn
            var resId = imgResId
            binding.mapSmileBtn.setImageResource(imgResId)
            binding.mapSmileBtn.setOnClickListener {
                resId =
                    if (resId == R.drawable.map_smile_default_btn)
                        R.drawable.map_smile_selected_btn
                    else
                        R.drawable.map_smile_default_btn
                binding.mapSmileBtn.setImageResource(resId)

            }

            //렌즈

            //안과
        }

        private fun initImage() {
            binding.mapLasekBtn.setImageResource(R.drawable.map_lasek_default_btn)
            binding.mapLasikBtn.setImageResource(R.drawable.map_lasik_default_btn)
            binding.mapSmileBtn.setImageResource(R.drawable.map_smile_default_btn)
            binding.mapLensBtn.setImageResource(R.drawable.map_lens_default_btn)
            binding.mapOphthalmologyBtn.setImageResource(R.drawable.map_ophthalmology_default_btn)
        }

}