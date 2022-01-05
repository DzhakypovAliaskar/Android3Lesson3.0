package com.example.android3lesson30.data.network.repositories;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.example.android3lesson30.App;
import com.example.android3lesson30.models.WeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    String apiKey = "2c0d9cc8cd2de0dcbb7d48179ab16927";
    String units = "metric";

    public MutableLiveData<WeatherModel> getWeather(String city) {
        MutableLiveData<WeatherModel> data = new MutableLiveData<>();
        App.weatherApiService.getWeather(city, apiKey, units).enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(@NonNull Call<WeatherModel> call, @NonNull Response<WeatherModel> response) {
                 if (response.isSuccessful() && response.body() != null) {
                     Log.e("tag", "getdata");
                     data.setValue(response.body());
                 }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherModel> call, @NonNull Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
