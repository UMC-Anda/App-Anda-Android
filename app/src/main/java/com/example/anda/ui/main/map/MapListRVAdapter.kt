package com.example.anda.ui.main.map

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anda.data.entities.MapList
import com.example.anda.data.entities.ReviewLasek
import com.example.anda.databinding.ItemLasekReviewBinding
import com.example.anda.databinding.ItemMapListBinding
import com.example.anda.ui.main.home.ReviewLasekRVAdapter

class MapListRVAdapter(private var listMapList: ArrayList<MapList>): RecyclerView.Adapter<MapListRVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MapListRVAdapter.ViewHolder {

        val binding: ItemMapListBinding = ItemMapListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MapListRVAdapter.ViewHolder, position: Int) {
        holder.bind(listMapList[position])
    }

    override fun getItemCount(): Int = listMapList.size

    inner class ViewHolder(val binding : ItemMapListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(listMapList: MapList){
            binding.itemMapListNameTv.text = listMapList.name
            binding.itemMapListTimeTv.text = listMapList.time
            binding.itemMapListReviewCntTv.text = listMapList.reviewCnt
            binding.itemMapListRatingRb.rating = listMapList.rating!!
        }
    }

}