package com.example.anda.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anda.data.entities.ReviewNearOphthalmology
import com.example.anda.databinding.ItemNearOphthalmologyReviewBinding

class ReviewNearOphthalmologyRVAdapter(private var nearOphthalmologyReviewList: ArrayList<ReviewNearOphthalmology>): RecyclerView.Adapter<ReviewNearOphthalmologyRVAdapter.ViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewNearOphthalmologyRVAdapter.ViewHolder {

        val binding:ItemNearOphthalmologyReviewBinding = ItemNearOphthalmologyReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewNearOphthalmologyRVAdapter.ViewHolder, position: Int) {
        holder.bind(nearOphthalmologyReviewList[position])
    }

    override fun getItemCount(): Int = nearOphthalmologyReviewList.size

    inner class ViewHolder(val binding :ItemNearOphthalmologyReviewBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(reviewOphthalmology:ReviewNearOphthalmology){
            binding.itemNearOphthalmologyOphthalmologyNameTv.text = reviewOphthalmology.name
            binding.itemNearOphthalmologyOphthalmologyLocationTv.text = reviewOphthalmology.location
            binding.itemNearOphthalmologyRatingRb.rating = reviewOphthalmology.rating!!
            binding.itemNearOphthalmologyOphthalmologyBestReviewTv.text = reviewOphthalmology.review
        }
    }

}