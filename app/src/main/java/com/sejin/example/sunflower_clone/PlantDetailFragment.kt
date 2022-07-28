package com.sejin.example.sunflower_clone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sejin.example.sunflower_clone.databinding.FragmentPlantDetailBinding

class PlantDetailFragment : Fragment() {
    lateinit var binding: FragmentPlantDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlantDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDetailToGallery.setOnClickListener { navigateToGallery() }
    }

    private fun navigateToGallery() {
        val direction =
            PlantDetailFragmentDirections.actionPlantDetailFragmentToGalleryFragment()
        findNavController().navigate(direction)
    }
}