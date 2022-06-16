package com.sox.api06.Recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sox.api06.API.PhotosDataItem
import com.sox.api06.R

class ItemAdapter(var itemList: List<PhotosDataItem>):RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater.inflate(R.layout.item_photo,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.render(itemList[position])
    }

    override fun getItemCount(): Int= itemList.size
}