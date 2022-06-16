package com.sox.api06.API

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("photos")
    fun getPhotos():Call<List<PhotosDataItem>>
}