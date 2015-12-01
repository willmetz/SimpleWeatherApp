package com.example.willmetz.simpleweatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by willmetz on 11/30/15.
 */
public class DaysHourForecast
{
    @SerializedName("hourly_forecast")
    List<HourForecast> hourlyForecast;
}
