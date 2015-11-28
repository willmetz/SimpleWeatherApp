package com.example.willmetz.simpleweatherapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by willmetz on 11/25/15.
 */
@Module(
        library = true,
        injects = WeatherListActivity.class

)
public class WeatherUndergroundAPI
{
    @Provides
    WeatherUndergroundService weatherUndergroundService()
    {
        Gson gson = new GsonBuilder()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://api.wunderground.com/api/d2b8132746efb3c6/")
                .setConverter(new GsonConverter(gson))
                .build();

        return restAdapter.create(WeatherUndergroundService.class);
    }
}
