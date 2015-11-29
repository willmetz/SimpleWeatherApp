package com.example.willmetz.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.willmetz.simpleweatherapp.R;

import butterknife.Bind;

/**
 * Created by willmetz on 11/29/15.
 */
public class WeatherDetails extends RelativeLayout
{
    private RecyclerView.LayoutManager layoutManager;


    @Bind( R.id.weather_list )
    RecyclerView recyclerView;

    public WeatherDetails(Context context)
    {
        super(context);
    }

    public WeatherDetails(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public WeatherDetails(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public void init()
    {
        inflate( getContext(), R.layout.weather_details_view, this );

        //user a linear layout manager
        layoutManager = new LinearLayoutManager( getContext() );
        recyclerView.setLayoutManager( layoutManager );
    }

}
