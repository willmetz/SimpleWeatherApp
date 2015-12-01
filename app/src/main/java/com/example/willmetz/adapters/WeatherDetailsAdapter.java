package com.example.willmetz.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.example.willmetz.simpleweatherapp.HourForecast;
import com.example.willmetz.views.WeatherListDayItem;

import java.util.List;

/**
 * Created by willmetz on 11/29/15.
 */
public class WeatherDetailsAdapter extends RecyclerView.Adapter<WeatherDetailsAdapter.ViewHolder>
{
    protected List<HourForecast> forecast;


    public WeatherDetailsAdapter ( List<HourForecast> daysForecast )
    {
        forecast = daysForecast;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        WeatherListDayItem listItem = new WeatherListDayItem( parent.getContext() );

        return new ViewHolder( listItem );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.setDayInfo( forecast.get( position ) );
    }

    @Override
    public int getItemCount()
    {
        return forecast.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        protected WeatherListDayItem weatherListDayItem;

        public ViewHolder(WeatherListDayItem itemView)
        {
            super(itemView);

            weatherListDayItem = itemView;
        }

        public void setDayInfo( HourForecast hourForecast )
        {
            weatherListDayItem.setTemeratureFarenheit( hourForecast.hourTemperature.fahrenheit );
            weatherListDayItem.setTimeOfDay( hourForecast.time );
        }
    }
}
