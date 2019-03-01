package com.g0ku.movie.tmdb_movie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.detail.MovieDetailFragment;
import com.g0ku.movie.tmdb_movie.ui.video.VideoListFragment;

public class MovieDetailFragmentPagerAdapter extends FragmentPagerAdapter {


    private Movie movie;

    public MovieDetailFragmentPagerAdapter(Movie movie, FragmentManager fm) {
        super(fm);
        this.movie = movie;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){

            case 0 :
                fragment = MovieDetailFragment.newInstance(movie);
                break;

            case 1:
                fragment = VideoListFragment.newInstance(movie);

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
