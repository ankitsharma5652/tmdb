package com.g0ku.movie.tmdb_movie.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.model.repo.MovieRepository;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeViewModel extends AndroidViewModel {

    private MovieRepository movieRepo;



    private MutableLiveData<List<Movie>> latestMovies = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);

        movieRepo = ((MyApplication)application).component().movieRepo();
    }


    public LiveData<List<Movie>> getLatestMovies() {
        return latestMovies;
    }

    public void requestLatest(){

        movieRepo.fetchTopRatedMovies(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {

                List<Movie> movieList  = latestMovies.getValue();

                if(movieList == null)
                    movieList = new ArrayList<>();

                if(response.body().getTotalResult() != null && response.body().getTotalResult() > 0)
                    movieList.addAll(response.body().movieList());

                latestMovies.postValue(movieList);
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
    }
}
