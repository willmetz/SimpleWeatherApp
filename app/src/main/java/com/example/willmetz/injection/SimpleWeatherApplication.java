package com.example.willmetz.injection;

import android.app.Application;
import com.example.willmetz.weatherapi.WeatherUndergroundAPI;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by willmetz on 12/5/15.
 */
public class SimpleWeatherApplication extends Application
{
    private ObjectGraph objectGraph;

    @Override
    public void onCreate()
    {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules()
    {
        return Arrays.asList(
                new WeatherModule( this ),
                new WeatherUndergroundAPI()
        );
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }
}
