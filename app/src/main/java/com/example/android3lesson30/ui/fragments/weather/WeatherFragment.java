package com.example.android3lesson30.ui.fragments.weather;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson30.R;
import com.example.android3lesson30.base.BaseFragment;
import com.example.android3lesson30.databinding.FragmentWeatherBinding;

import java.time.Instant;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class WeatherFragment extends BaseFragment<WeatherViewModel, FragmentWeatherBinding> {

    public WeatherFragment(){
    }

    private void cityFragment(){
        binding.locationBtn.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_weatherFragment_to_cityFragment);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        cityFragment();
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void setUpObserves() {
        viewModel.getWeather(WeatherFragmentArgs.fromBundle(getArguments()).getCityName()).observe(getViewLifecycleOwner(), weatherModels -> {
            binding.locationBtn.setText(weatherModels.getName());
            binding.maxTemperature.setText(String.valueOf(weatherModels.getMain().getTempMax()));
            binding.minTemperature.setText(String.valueOf(weatherModels.getMain().getTempMin()));
            binding.speedTv.setText(String.valueOf(weatherModels.getWind().getSpeed()));
            binding.temperatureTv.setText(String.valueOf(weatherModels.getCoord().getLat()));
            binding.cloudTv.setText(String.valueOf(weatherModels.getClouds().getAll()));
            binding.humidityTv.setText(String.valueOf(weatherModels.getMain().getHumidity()));
            binding.pressureTv.setText(String.valueOf(weatherModels.getMain().getPressure()));
            binding.sunriseTv.setText(String.valueOf(weatherModels.getSys().getSunrise()));
            binding.sunsetTv.setText(String.valueOf(weatherModels.getSys().getSunset()));
            binding.date.setText(String.valueOf(Instant.ofEpochSecond(weatherModels.getDt())));
        });
    }
}