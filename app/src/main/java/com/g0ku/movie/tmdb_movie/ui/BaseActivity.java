package com.g0ku.movie.tmdb_movie.ui;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    @CallSuper
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((MyApplication)getApplication()).component());


    }


    public void inject(ApplicationComponent component){}
}
