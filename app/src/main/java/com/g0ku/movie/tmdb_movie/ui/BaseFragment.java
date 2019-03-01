package com.g0ku.movie.tmdb_movie.ui;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;

public class BaseFragment extends Fragment {



    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getActivity() != null)
        inject(((MyApplication)getActivity().getApplication()).component());

    }



    public void inject(ApplicationComponent component){}


    protected AppCompatActivity activity(){
        return (AppCompatActivity) getActivity();
    }

}
