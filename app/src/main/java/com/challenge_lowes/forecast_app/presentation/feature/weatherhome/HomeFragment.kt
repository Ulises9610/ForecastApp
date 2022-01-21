package com.challenge_lowes.forecast_app.presentation.feature.weatherhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.challenge_lowes.forecast_app.R
import com.challenge_lowes.forecast_app.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<WeatherViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLookUp.setOnClickListener {
            viewModel.getWeather(binding.etCityName.text.toString())
        }

        viewModel.data.observe(viewLifecycleOwner, { result ->
            when (result) {
                is WeatherViewState.Error ->changeLoadingState(show = false, error = true)
                is WeatherViewState.Loading -> changeLoadingState(show = true, error = false)
                is WeatherViewState.Success -> {
                    result.data?.let {
                        val action =
                            HomeFragmentDirections.actionHomeFragmentToWeatherFragment(
                                it.toTypedArray()
                            )


                        requireActivity().findNavController(R.id.nav_host_fragment).navigate(action)
                        viewModel.resetData()
                    }
                }
            }

        })
    }
    private fun changeLoadingState(show: Boolean, error: Boolean){
        binding.apply {
            if (show){
                progressLoading.visibility = View.VISIBLE
            }else{
                progressLoading.visibility = View.GONE
                if (error)
                Toast.makeText(
                    context,
                    resources.getString(R.string.generalError),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}