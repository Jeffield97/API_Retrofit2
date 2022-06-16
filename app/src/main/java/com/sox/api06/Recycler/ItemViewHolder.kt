package com.sox.api06.Recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sox.api06.API.PhotosDataItem
import com.sox.api06.databinding.ItemPhotoBinding

class ItemViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var binding = ItemPhotoBinding.bind(view)
    var album = binding.albumId
    var id = binding.id
    var thumbnailUrl = binding.thumbnailUrl
    var url = binding.url
    var title = binding.title

    fun render(photosDataItem: PhotosDataItem) {
        album.text = photosDataItem.albumId.toString()
        id.text = photosDataItem.id.toString()
        thumbnailUrl.text = photosDataItem.thumbnailUrl
        url.text = photosDataItem.url
        title.text = photosDataItem.title

    }
}