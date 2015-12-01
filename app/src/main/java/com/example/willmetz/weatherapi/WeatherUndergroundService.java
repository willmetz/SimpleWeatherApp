package com.example.willmetz.weatherapi;

import com.example.willmetz.simpleweatherapp.DaysHourForecast;
import com.example.willmetz.simpleweatherapp.Forecast;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by willmetz on 11/25/15.
 */
public interface WeatherUndergroundService
{

    @GET("/forecast/q/{state}/{city}.json")
    void getForecast( @Path("state") String state, @Path("city") String city, Callback<Forecast> callback);

    @GET("hourly/q/{state}/{city}.json")
    void getHourlyForecast( @Path("state") String state, @Path("city") String city, Callback<DaysHourForecast> callback);

}
