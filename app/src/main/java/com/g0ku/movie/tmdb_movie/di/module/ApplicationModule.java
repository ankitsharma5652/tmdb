package com.g0ku.movie.tmdb_movie.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;

import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.NonNull;

@Module
public class ApplicationModule {

    private Application app;


    public ApplicationModule( Application application) {
        this.app = application;
    }

    @ApplicationScope
    @Provides
    public Context context() {
        return app.getApplicationContext();
    }

 @ApplicationScope
    @Provides
    public Application application() {
        return app;
    }


    @ApplicationScope
    @Provides
    public Resources provideResource() {
        return app.getResources();
    }


}
