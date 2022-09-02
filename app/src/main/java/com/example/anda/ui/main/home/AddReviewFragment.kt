package com.example.anda.ui.main.home

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.anda.databinding.FragmentHomeAddReviewBinding
import com.example.anda.databinding.FragmentHomeBinding
import com.example.anda.ui.BaseFragment

class AddReviewFragment: BaseFragment<FragmentHomeAddReviewBinding>(FragmentHomeAddReviewBinding::inflate) {
    override fun initAfterBinding() {
        //특정 글씨만 굵게
        val myReviewTextView : TextView = binding.homeAddReviewTv
        val myReviewText:String = "#나의 리뷰 쓰기"
        val myReviewSpanString: SpannableString = SpannableString(myReviewText)
        myReviewSpanString.setSpan(StyleSpan(Typeface.BOLD),0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        myReviewTextView.text = myReviewSpanString
    }
}
