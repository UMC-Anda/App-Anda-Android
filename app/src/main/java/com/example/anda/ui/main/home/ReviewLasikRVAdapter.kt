package com.example.anda.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anda.data.entities.ReviewLasik
import com.example.anda.databinding.ItemLasikReviewBinding

class ReviewLasikRVAdapter(private var lasikReviewList: ArrayList<ReviewLasik>): RecyclerView.Adapter<ReviewLasikRVAdapter.ViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReviewLasikRVAdapter.ViewHolder {

        val binding:ItemLasikReviewBinding = ItemLasikReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewLasikRVAdapter.ViewHolder, position: Int) {
        holder.bind(lasikReviewList[position])
    }

    override fun getItemCount(): Int = lasikReviewList.size

    inner class ViewHolder(val binding :ItemLasikReviewBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(reviewLasik:ReviewLasik){
            binding.itemLasikOphthalmologyNameTv.text = reviewLasik.name
            binding.itemLasikOphthalmologyLocationTv.text = reviewLasik.location
            binding.itemLasikRatingRb.rating = reviewLasik.rating!!
            binding.itemLasikOphthalmologyBestReviewTv.text = reviewLasik.review
        }
    }

}