package com.example.willmetz.simpleweatherapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.willmetz.injection.SimpleWeatherApplication;

/**
 * Created by willmetz on 12/5/15.
 */
public class BaseActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Perform injection so that when this call returns all dependencies will be available for use.
        ((SimpleWeatherApplication) getApplication()).inject(this);
    }
}
