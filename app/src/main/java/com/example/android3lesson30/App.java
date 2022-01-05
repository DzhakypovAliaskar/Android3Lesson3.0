package com.example.android3lesson30;

import android.app.Application;
import com.example.android3lesson30.data.network.remote.RetrofitClient;
import com.example.android3lesson30.data.network.apiservise.WeatherApiService;

public class App extends Application {

    public RetrofitClient retrofitClient;
    public static WeatherApiService weatherApiService;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        weatherApiService = retrofitClient.provideApi();
    }
}
