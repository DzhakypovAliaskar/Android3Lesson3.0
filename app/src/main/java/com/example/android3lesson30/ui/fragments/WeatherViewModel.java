package com.example.android3lesson30.ui.fragments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.android3lesson30.data.network.repositories.WeatherRepository;
import com.example.android3lesson30.models.WeatherModel;

public class WeatherViewModel extends ViewModel {

    String city = "Bishkek";
    private final WeatherRepository repository = new WeatherRepository();

    public MutableLiveData<WeatherModel> getWeather() {
        return repository.getWeather(city);
    }
}
