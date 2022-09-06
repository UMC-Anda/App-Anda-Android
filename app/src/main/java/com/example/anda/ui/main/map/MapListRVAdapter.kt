    //package com.example.anda.ui.main.map
    //
    //import android.view.LayoutInflater
    //import android.view.ViewGroup
    //import androidx.recyclerview.widget.RecyclerView
    //import com.example.anda.data.entities.MapList
    //import com.example.anda.databinding.ItemMapListBinding
    //
    //class MapListRVAdapter (private var MapListList: ArrayList<MapList>): RecyclerView.Adapter<MapListRVAdapter.ViewHolder>(){
    //
    //
    ////        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MapListRVAdapter.ViewHolder {
    //
    //                val binding:ItemMapListBinding = ItemMapListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
    //
    //                return ViewHolder(binding)
    //        }
    //
    //        override fun onBindViewHolder(holder: MapListRVAdapter.ViewHolder, position: Int) {
    //                holder.bind(MapListList[position])
    //        }
    //
    //        override fun getItemCount(): Int = MapListList.size
    //
    //        inner class ViewHolder(val binding :ItemMapListBinding):RecyclerView.ViewHolder(binding.root){
    //
    //
    //                fun bind(maplist:MapList){
    //                        binding.itemMapListNameTv.text = MapList.name
    //                        binding.itemLasekOphthalmologyLocationTv.text = MapList.location
    //                        binding.itemLasekRatingRb.rating = MapList.rating!!
    //                        binding.itemLasekOphthalmologyBestReviewTv.text = MapList.review
    //                }
    //        }
    //
    //}