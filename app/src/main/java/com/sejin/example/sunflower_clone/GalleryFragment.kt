package com.sejin.example.sunflower_clone

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sejin.example.sunflower_clone.adapters.UnsplashApi
import com.sejin.example.sunflower_clone.adapters.UnsplashService
import com.sejin.example.sunflower_clone.data.UnsplashSearchResponse
import com.sejin.example.sunflower_clone.databinding.FragmentGalleryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryFragment : Fragment() {

    val args: PlantDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val call = UnsplashApi.retrofitService.searchPhotos(
            "apple",
            10,
            10
        )
        val callback = object : Callback<UnsplashSearchResponse> {
            override fun onResponse(
                call: Call<UnsplashSearchResponse>,
                response: Response<UnsplashSearchResponse>
            ) {
                Log.i("TTAAGG", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<UnsplashSearchResponse>, t: Throwable) {
                Log.i("TTAAGG", "onFailure: ${t.message}")
            }
        }

        call.enqueue(callback)
    }
}