package com.example.android3lesson30.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.android3lesson30.databinding.FragmentWeatherBinding;
import com.example.android3lesson30.models.WeatherModel;

public class WeatherFragment extends Fragment {

    private FragmentWeatherBinding binding;
    private WeatherViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
        viewModel.getWeather().observe(getViewLifecycleOwner(), new Observer<WeatherModel>() {
            @Override
            public void onChanged(WeatherModel weatherModel) {

            }
        });
    }

    private void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(WeatherViewModel.class);
    }
}