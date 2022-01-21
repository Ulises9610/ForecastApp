package com.challenge_lowes.forecast_app.presentation.feature.weatherdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.challenge_lowes.forecast_app.R
import com.challenge_lowes.forecast_app.databinding.FragmentWeatherDetailBinding

class WeatherDetailFragment : Fragment() {
    private lateinit var binding: FragmentWeatherDetailBinding
    private val args by navArgs<WeatherDetailFragmentArgs>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherDetailBinding.inflate(inflater)

        //Toolbar
        requireActivity().setActionBar(binding.toolbar)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(true)
        requireActivity().actionBar?.title = args.weather.cityName

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().findNavController(R.id.nav_host_fragment).popBackStack()
        }

        binding.tvTemp.text = args.weather.temp.toString()
        binding.tvClouds.text = args.weather.weatherDescription
        binding.tvFeelsLikeTemp.text =
            getString(R.string.weather_details_feelslike, args.weather.feelsLikeTemp)
        return binding.root
    }

}