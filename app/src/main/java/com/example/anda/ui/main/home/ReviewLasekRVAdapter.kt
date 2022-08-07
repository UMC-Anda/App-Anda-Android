package com.example.anda.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anda.data.entities.ReviewLasek
import com.example.anda.databinding.ItemLasekReviewBinding

class ReviewLasekRVAdapter(private var lasekReviewList: ArrayList<ReviewLasek>): RecyclerView.Adapter<ReviewLasekRVAdapter.ViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewLasekRVAdapter.ViewHolder {

        val binding:ItemLasekReviewBinding = ItemLasekReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewLasekRVAdapter.ViewHolder, position: Int) {
        holder.bind(lasekReviewList[position])
    }

    override fun getItemCount(): Int = lasekReviewList.size

    inner class ViewHolder(val binding :ItemLasekReviewBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(reviewLasek:ReviewLasek){
            binding.itemLasekOphthalmologyNameTv.text = reviewLasek.name
            binding.itemLasekOphthalmologyLocationTv.text = reviewLasek.location
            binding.itemLasekRatingRb.rating = reviewLasek.rating!!
            binding.itemLasekOphthalmologyBestReviewTv.text = reviewLasek.review
        }
    }

}