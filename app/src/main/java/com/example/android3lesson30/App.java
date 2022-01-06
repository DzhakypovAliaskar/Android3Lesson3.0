package com.example.android3lesson30;

import android.app.Application;
import com.example.android3lesson30.data.network.remote.RetrofitClient;
import com.example.android3lesson30.data.network.apiservise.WeatherApiService;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
