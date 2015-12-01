package com.example.willmetz.simpleweatherapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by willmetz on 11/30/15.
 */
public class HourForecast
{
    @SerializedName("month_name")
    public String month;

    @SerializedName("civil")
    public String time;

    @SerializedName("weekday_name")
    public String weekdayName;

    @SerializedName("temp")
    public Temperature hourTemperature;

    @SerializedName("hour")
    public String hour;

    @SerializedName("min")
    public String minutes;

    public String year;

    public class Temperature
    {
        @SerializedName("english")
        public int fahrenheit;

        @SerializedName("metric")
        public int celcius;
    }

}
