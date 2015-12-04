package com.example.willmetz.weatherapi;

import com.example.willmetz.weatherapi.HourForecast;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by willmetz on 11/30/15.
 */
public class DaysHourForecast
{
    @SerializedName("hourly_forecast")
    public List<HourForecast> hourlyForecast;
}
