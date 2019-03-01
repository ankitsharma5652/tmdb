package com.g0ku.movie.tmdb_movie.ui.detail;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.MovieDetailFragmentPagerAdapter;
import com.g0ku.movie.tmdb_movie.adapter.VideoPagerAdapter;
import com.g0ku.movie.tmdb_movie.databinding.ActivityMovieDetailBinding;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.BaseActivity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;


public class MovieDetailActivity extends BaseActivity {


    private Movie movie;

    private MovieDetailFragmentPagerAdapter adapter;
    private ActivityMovieDetailBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_detail);

        if(getIntent() == null || !getIntent().hasExtra(Movie.TAG)){

            Toast.makeText(this, "Failed to get Movie", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        movie = (Movie) getIntent().getSerializableExtra(Movie.TAG);


        adapter = new MovieDetailFragmentPagerAdapter(movie,getSupportFragmentManager());

        mBinding.movieContainer.setAdapter(adapter);

    }


}
