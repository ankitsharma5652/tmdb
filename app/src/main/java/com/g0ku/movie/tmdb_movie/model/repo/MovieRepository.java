package com.g0ku.movie.tmdb_movie.model.repo;

import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.pojo.MovieVideo;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@ApplicationScope
public class MovieRepository {


    private DataManager dataManager;
    private static final String TAG ="movie_repo";

    @Inject
    MovieRepository(DataManager dataManager) {
        this.dataManager = dataManager;

    }


    public void fetchVideo(Movie movie,@NonNull Callback<MovieVideo> mCallback) {


        dataManager.movie().movieVideo(movie.getId()).enqueue(mCallback);
    }

    public void search(HashMap<String,String> searchMap, Callback<MovieResult> callback) {
        dataManager.movie().search(searchMap).enqueue(callback);

    }


    public void fetchTopRatedMovies(@NonNull Callback<MovieResult> callback) {
        dataManager.movie().topRated().enqueue(callback);

    }
}
