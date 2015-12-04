package com.example.willmetz.simpleweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.willmetz.adapters.WeatherDetailsAdapter;
import com.example.willmetz.views.WeatherDetails;
import com.example.willmetz.views.WeatherHeader;
import com.example.willmetz.weatherapi.DaysHourForecast;
import com.example.willmetz.weatherapi.WeatherUndergroundAPI;
import com.example.willmetz.weatherapi.WeatherUndergroundService;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import dagger.ObjectGraph;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class WeatherListActivity extends AppCompatActivity implements WeatherSelectionInterface
{

    private ObjectGraph objectGraph;
    @Inject
    WeatherUndergroundService weatherUndergroundService;

    @Bind(R.id.weather_header )
    WeatherHeader weatherHeader;


    @Bind( R.id.weather_details)
    WeatherDetails weatherDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        objectGraph = ObjectGraph.create(new WeatherUndergroundAPI());
        objectGraph.inject(this);

        ButterKnife.bind( this );

        weatherHeader.setListener( this );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void locationChanged(String city, String state)
    {
        weatherDetails.showProgressBar();

        //clean the city up
        city = city.replace( ' ', '_' );

        weatherUndergroundService.getHourlyForecast( state, city, new HourlyWeatherCallback() );
    }


    protected class HourlyWeatherCallback implements Callback<DaysHourForecast>
    {
        @Override
        public void success(DaysHourForecast daysHourForecast, Response response)
        {
            if( weatherDetails != null )
            {
                weatherDetails.hideProgressBar();

                if( daysHourForecast.hourlyForecast != null )
                {
                    weatherDetails.setListAdatper(new WeatherDetailsAdapter(daysHourForecast.hourlyForecast));
                }
                else
                {
                    Toast.makeText( WeatherListActivity.this, "Unable to get weather info", Toast.LENGTH_SHORT ).show();
                }
            }
        }

        @Override
        public void failure(RetrofitError error)
        {
            if( weatherDetails != null )
            {
                Toast.makeText( WeatherListActivity.this, "Error retrieving info", Toast.LENGTH_SHORT ).show();
            }
        }
    }
}
