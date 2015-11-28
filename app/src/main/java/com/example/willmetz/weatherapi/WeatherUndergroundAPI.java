package com.example.willmetz.weatherapi;

import com.example.willmetz.simpleweatherapp.APIKeyDontCommit;
import com.example.willmetz.simpleweatherapp.WeatherListActivity;
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
    private static final String BASE_URL = "http://api.wunderground.com/api/" + APIKeyDontCommit.API_KEY + "/";


    @Provides
    WeatherUndergroundService weatherUndergroundService()
    {
        Gson gson = new GsonBuilder()
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        return restAdapter.create(WeatherUndergroundService.class);
    }
}
