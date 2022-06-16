package com.sox.api06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sox.api06.API.APIService
import com.sox.api06.API.PhotosDataItem
import com.sox.api06.Recycler.ItemAdapter
import com.sox.api06.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var listItems: List<PhotosDataItem>
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()

    }

    private fun initRecycler() {
        recyclerView =binding.rvItems
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(listItems)
    }

    fun getData()
    {
        var call = getRetrofit().create<APIService>(APIService::class.java).getPhotos()
        call.enqueue(object : Callback<List<PhotosDataItem>> {
            override fun onResponse(
                call: Call<List<PhotosDataItem>>,
                response: Response<List<PhotosDataItem>>
            ) {
                Toast.makeText(this@MainActivity,response.body().toString(),Toast.LENGTH_SHORT).show()
                listItems = response.body()!!
                initRecycler()
            }

            override fun onFailure(call: Call<List<PhotosDataItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error al recuperar la información...",Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getRetrofit():Retrofit
    {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}