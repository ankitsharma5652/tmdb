package com.g0ku.movie.tmdb_movie.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.repo.MovieRepository;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.pojo.MovieVideo;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoListViewModel extends AndroidViewModel {


    private MutableLiveData<MovieVideo> movieVideo = new MutableLiveData<>();
    private Movie movie;

    @Inject
    MovieRepository movieRepository;

    public VideoListViewModel(@NonNull Application application) {
        super(application);


        ((MyApplication)application).component().inject(this);
    }

    public void fetchMovie(Bundle bundle){

        movie = (Movie) bundle.getSerializable(Movie.TAG);

    }


    public void fetchVideo(){

        if(movie == null) return;

        movieRepository.fetchVideo(movie, new Callback<MovieVideo>() {
            @Override
            public void onResponse(@NonNull Call<MovieVideo> call,@NonNull Response<MovieVideo> response) {
                if(response.isSuccessful())
                setMovie(response.body());
                else
                    setMovie(null);
            }

            @Override
            public void onFailure(@NonNull Call<MovieVideo> call,@NonNull Throwable t) {
                setMovie(null);

            }
        });
    }



    public void setMovie(MovieVideo movieVideo){

        this.movieVideo.setValue(movieVideo);
    }

    public LiveData<MovieVideo> getMovieVideo() {
        return movieVideo;
    }
}
