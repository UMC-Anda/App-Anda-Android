package com.example.anda.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anda.data.entities.ReviewOphthalmology
import com.example.anda.databinding.ItemOphthalmologyReviewBinding

class ReviewOphthalmologyRVAdapter(private var ophthalmologyReviewList: ArrayList<ReviewOphthalmology>): RecyclerView.Adapter<ReviewOphthalmologyRVAdapter.ViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewOphthalmologyRVAdapter.ViewHolder {

        val binding:ItemOphthalmologyReviewBinding = ItemOphthalmologyReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewOphthalmologyRVAdapter.ViewHolder, position: Int) {
        holder.bind(ophthalmologyReviewList[position])
    }

    override fun getItemCount(): Int = ophthalmologyReviewList.size

    inner class ViewHolder(val binding :ItemOphthalmologyReviewBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(reviewOphthalmology:ReviewOphthalmology){
            binding.itemOphthalmologyOphthalmologyNameTv.text = reviewOphthalmology.name
            binding.itemOphthalmologyOphthalmologyLocationTv.text = reviewOphthalmology.location
            binding.itemOphthalmologyRatingRb.rating = reviewOphthalmology.rating!!
            binding.itemOphthalmologyOphthalmologyBestReviewTv.text = reviewOphthalmology.review
        }
    }

}