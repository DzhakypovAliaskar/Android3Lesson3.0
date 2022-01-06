package com.example.android3lesson30.data.network.apiservise;

import com.example.android3lesson30.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {

    @GET("weather")
    Call<WeatherModel> getWeather(
            @Query("q") String q,
            @Query("appid") String appid,
            @Query("units") String units
    );
}
