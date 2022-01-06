package com.example.android3lesson30.data.network.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.android3lesson30.App;
import com.example.android3lesson30.data.network.apiservise.WeatherApiService;
import com.example.android3lesson30.models.WeatherModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    private WeatherApiService apiService;

    String apiKey = "2c0d9cc8cd2de0dcbb7d48179ab16927";
    String units = "metric";

    @Inject
    public WeatherRepository(WeatherApiService apiService) {
        this.apiService = apiService;
    }

    public MutableLiveData<WeatherModel> getWeather(String city) {
        MutableLiveData<WeatherModel> data = new MutableLiveData<>();
        apiService.getWeather(city, apiKey, units).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(@NonNull Call<WeatherModel> call, @NonNull Response<WeatherModel> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<WeatherModel> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
