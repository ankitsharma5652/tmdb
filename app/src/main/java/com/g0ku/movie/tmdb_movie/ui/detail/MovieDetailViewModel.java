package com.g0ku.movie.tmdb_movie.ui.detail;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import com.g0ku.movie.tmdb_movie.pojo.Movie;


public class MovieDetailViewModel extends ViewModel {

    private MutableLiveData<Movie> movie ;


    public MovieDetailViewModel() {
        movie = new MutableLiveData<>();
    }


    public void setMovie(Movie movie){
        this.movie.setValue(movie);
    }

    public LiveData<Movie> getMovie() {
        return movie;
    }


}
