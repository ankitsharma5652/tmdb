package com.g0ku.movie.tmdb_movie.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {


    private MutableLiveData<List<Movie>> movieList;
    private MutableLiveData<String> message;
    private MutableLiveData<Boolean> isLoading;
    private String genres;

    private int mPage = 1;
    private DataManager dataManager;
    private int id;
//f26 58
    public MovieListViewModel() {
        this.movieList = new MutableLiveData<>();
        message = new MutableLiveData<>();
        isLoading = new MutableLiveData<>();
    }


    public void setGenres(String genres) {
        this.genres = genres;
    }

    public LiveData<List<Movie>> getMovieList() {
        return movieList;
    }


    public void setDataManager(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public void loadMore(){
         if(isLoading())return;


         isLoading.setValue(true);

        mPage++;
        fetchMovie();
    }

    public void fetchMovie(){

        Call<MovieResult> result = null;
        switch (id){

            case HomeItem.POPULAR:
                result = dataManager.movie().popular(mPage);
                break;
            case HomeItem.LATEST:
                result = dataManager.movie().latest(mPage);
                break;
            case HomeItem.TOP_RATED:
                result = dataManager.movie().topRated(mPage);
                break;
                case HomeItem.UPCOMING:
                result = dataManager.movie().upcoming(mPage);

                break;
            case HomeItem.SEARCH :
                HashMap<String,String> map = new HashMap<>();
                map.put("with_genres",genres);
                map.put("page", String.valueOf(mPage));
                result = dataManager.movie().searchGenres(map);
                break;

        }
        if(result != null)
        result.enqueue(mServiceCallback);

    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    private boolean isLoading(){return isLoading.getValue() != null && isLoading.getValue();}

    public LiveData<String> msg(){return message;}

    private Callback<MovieResult> mServiceCallback = new Callback<MovieResult>() {
        @Override
        public void onResponse(@NonNull Call<MovieResult> call, Response<MovieResult> response) {

            if(!response.isSuccessful()) {
                message.setValue("Invalid response");
                return;
            }

            MovieResult result  = response.body();

            if(result.movieList().isEmpty()) {
                message.setValue("No movie found...");
                return;
            }

                movieList.setValue(result.movieList());


            isLoading.setValue(false);
        }

        @Override
        public void onFailure(Call<MovieResult> call, Throwable t) {

            message.setValue("Failed to load");
            isLoading.setValue(false);

        }
    };


    public void setMovieID(Intent intent, int id) {

        if(id == HomeItem.SEARCH)
            genres = intent.getStringExtra(MovieListActivity.GENRES);

        this.id = id;
    }
}
