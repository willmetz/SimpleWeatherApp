package com.example.willmetz.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.willmetz.simpleweatherapp.R;



import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by willmetz on 11/30/15.
 */
public class WeatherListDayItem extends RelativeLayout
{
    @Bind( R.id.time )
    TextView timeOfDay;

    @Bind( R.id.temperature )
    TextView temperatureAtTime;

    public WeatherListDayItem(Context context)
    {
        super(context);
        init();
    }

    public WeatherListDayItem(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public WeatherListDayItem(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setTimeOfDay( String time )
    {
        timeOfDay.setText(time);
    }

    public void setTemeratureFarenheit( int temperature )
    {
        temperatureAtTime.setText( "%d F");
    }


    private void init()
    {
        inflate( getContext(), R.layout.time_weather_listview_item, this );

        ButterKnife.bind( this );
    }

}
