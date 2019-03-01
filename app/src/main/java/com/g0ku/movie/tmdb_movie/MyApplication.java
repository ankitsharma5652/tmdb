package com.g0ku.movie.tmdb_movie;

import android.app.Application;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import com.g0ku.movie.tmdb_movie.di.component.DaggerApplicationComponent;
import com.g0ku.movie.tmdb_movie.di.module.ApplicationModule;


public class MyApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();



//        if (LeakCanary.isInAnalyzerProcess(this)) {
        // This process is dedicated to LeakCanary for heap analysis.
        // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
        // Normal app init code...
//    }

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();


    }

    public ApplicationComponent component() {

        return component;
    }
}
