package com.example.android3lesson30.di;

import com.example.android3lesson30.data.network.apiservise.WeatherApiService;
import com.example.android3lesson30.data.network.repositories.WeatherRepository;
import java.util.concurrent.TimeUnit;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static WeatherRepository provideWeatherRepository(WeatherApiService apiService){
        return new WeatherRepository(apiService );
    }

    @Provides
    public static WeatherApiService provideApi(Retrofit retrofit){
        return retrofit .create(WeatherApiService.class );
    }
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static OkHttpClient provideOkhttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build();
    }
}
