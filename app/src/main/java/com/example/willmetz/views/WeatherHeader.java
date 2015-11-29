package com.example.willmetz.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.willmetz.simpleweatherapp.R;
import com.example.willmetz.simpleweatherapp.WeatherSelectionInterface;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * Created by willmetz on 11/27/15.
 */
public class WeatherHeader extends RelativeLayout
{
    @Bind(R.id.cityInput)
    EditText cityInput;

    @Bind(R.id.stateInput)
    EditText stateInput;

    protected WeatherSelectionInterface listener;

    public WeatherHeader(Context context)
    {
        super(context);
        init();
    }

    public WeatherHeader(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public WeatherHeader(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setListener( WeatherSelectionInterface weatherSelectionInterface )
    {
        listener = weatherSelectionInterface;
    }

    private void init()
    {
        inflate(getContext(), R.layout.weather_header_view, this);
        ButterKnife.bind(this);
    }


    @OnTextChanged( R.id.cityInput )
    void onCityChanged( CharSequence city )
    {
        if( listener != null )
        {
            listener.locationChanged( city.toString(), stateInput.getText().toString() );
        }
    }

    @OnTextChanged( R.id.stateInput )
    void onStateChanged( CharSequence state )
    {
        if( listener != null )
        {
            listener.locationChanged( cityInput.getText().toString(), state.toString() );
        }
    }
}
