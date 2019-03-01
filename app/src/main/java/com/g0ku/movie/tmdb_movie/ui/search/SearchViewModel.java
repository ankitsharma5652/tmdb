package com.g0ku.movie.tmdb_movie.ui.search;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.model.repo.MovieRepository;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends AndroidViewModel {

    @Inject
    DataManager dataManager;
    private MovieRepository movieRepository;
    private int mPage ;
    private String search;
    private boolean isLoading;

    private MutableLiveData<List<Movie>> movieList = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);

        dataManager = ((MyApplication)application).component().dataManager();
        movieRepository= ((MyApplication)application).component().movieRepo();
    }

    public void loadMore(){
        search(search);
    }


    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }


    public void startSearch(String search){
        this.search = Uri.encode(search);

        search(this.search);
    }
    private void search(String search){

        if(isLoading) return;

        isLoading = true;

        this.search = search;
        HashMap<String,String> searchMap = new HashMap<>();

        searchMap.put("query",search);
        searchMap.put("page",String.valueOf(++mPage));

        movieRepository.search(searchMap, new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {

                if(response.body().getTotalResult() != null&&response.body().getTotalResult()> 0)
                movieList.setValue(response.body().movieList());

                isLoading = false;
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
                mPage--;
                isLoading = false;

            }
        });

    }


}
