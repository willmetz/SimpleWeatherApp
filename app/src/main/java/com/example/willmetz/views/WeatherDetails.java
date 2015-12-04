package com.example.willmetz.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.willmetz.adapters.WeatherDetailsAdapter;
import com.example.willmetz.simpleweatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by willmetz on 11/29/15.
 */
public class WeatherDetails extends RelativeLayout
{
    private RecyclerView.LayoutManager layoutManager;


    @Bind( R.id.weather_list )
    RecyclerView recyclerView;

    @Bind( R.id.progress_bar )
    ProgressBar progressBar;

    public WeatherDetails(Context context)
    {
        super(context);
        init();
    }

    public WeatherDetails(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public WeatherDetails(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        inflate( getContext(), R.layout.weather_details_view, this );

        ButterKnife.bind( this );

        //user a linear layout manager
        layoutManager = new LinearLayoutManager( getContext() );
        recyclerView.setLayoutManager(layoutManager);

        progressBar.setIndeterminate(true);
        progressBar.setVisibility( INVISIBLE );
    }

    public void setListAdatper( WeatherDetailsAdapter adapter)
    {
        recyclerView.setAdapter( adapter );
    }

    public void showProgressBar()
    {
        progressBar.setVisibility( VISIBLE );
    }

    public void hideProgressBar()
    {
        progressBar.setVisibility( GONE );
    }

}
