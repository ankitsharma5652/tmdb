package com.g0ku.movie.tmdb_movie.ui.list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MovieListActivity extends AppCompatActivity {

    public static final String ITEM = "item";
    public static final String GENRES = "genre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_list);


        Intent i = getIntent();



        getSupportFragmentManager().beginTransaction()
                .add(R.id.list_container,MovieListFragment.newInstance(i.getIntExtra(ITEM,-1)),MovieListFragment.TAG)
                .commit();

    }
}
