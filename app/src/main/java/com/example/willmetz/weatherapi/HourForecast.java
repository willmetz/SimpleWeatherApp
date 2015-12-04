package com.example.willmetz.weatherapi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by willmetz on 11/30/15.
 */
public class HourForecast
{
    @SerializedName("month_name")
    public String month;



    @SerializedName("weekday_name")
    public String weekdayName;

    @SerializedName("temp")
    public Temperature hourTemperature;

    @SerializedName("hour")
    public String hour;

    @SerializedName("min")
    public String minutes;

    public String year;

    @SerializedName( "FCTTIME" )
    public FCTime forecastTime;

    public class Temperature
    {
        @SerializedName("english")
        public int fahrenheit;

        @SerializedName("metric")
        public int celcius;
    }

    public class FCTime
    {
        @SerializedName("civil")
        public String formatedTime;

        public String hour;
    }

}
