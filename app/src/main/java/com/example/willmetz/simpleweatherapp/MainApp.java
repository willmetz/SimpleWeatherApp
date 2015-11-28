package com.example.willmetz.simpleweatherapp;

import android.app.Application;

import com.example.willmetz.weatherapi.WeatherUndergroundAPI;

import dagger.ObjectGraph;

/**
 * Created by willmetz on 11/25/15.
 */
public class MainApp extends Application
{
    private ObjectGraph objectGraph;


    @Override
    public void onCreate()
    {
        super.onCreate();

        objectGraph = ObjectGraph.create( new WeatherUndergroundAPI() );
        objectGraph.inject(this);
    }

}
