package com.example.willmetz.injection;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by willmetz on 12/5/15.
 */
@Module(library = true)
public class WeatherModule
{
    private final SimpleWeatherApplication application;

    public WeatherModule( SimpleWeatherApplication application )
    {
        this.application = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton @ForApplication
    Context provideApplicationContext() {
        return application;
    }
}
