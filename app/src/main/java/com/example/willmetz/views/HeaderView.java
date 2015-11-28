package com.example.willmetz.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.willmetz.simpleweatherapp.R;

import butterknife.Bind;

/**
 * Created by willmetz on 11/27/15.
 */
public class HeaderView extends RelativeLayout
{
    @Bind(R.id.cityInput)
    EditText city;

    @Bind(R.id.stateInput)
    EditText state;

    public HeaderView(Context context)
    {
        super(context);
        init();
    }

    public HeaderView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        inflate(getContext(), R.layout.header_view, this);
    }
}
