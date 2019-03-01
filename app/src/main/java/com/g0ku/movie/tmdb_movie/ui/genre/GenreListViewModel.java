package com.g0ku.movie.tmdb_movie.ui.genre;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.response.GenreList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class GenreListViewModel extends AndroidViewModel {


    private MutableLiveData<GenreList> list;

    private CompositeDisposable disposable;
    private DataManager dataManager;

    public GenreListViewModel(Application application) {
        super(application);
        this.list = new MutableLiveData<>();
        disposable = new CompositeDisposable();
        dataManager = ((MyApplication) application).component().dataManager();
    }


    public LiveData<GenreList> getList() {
        return list;
    }

    public void fetchGenres() {

        Disposable d = Observable.fromCallable(() -> {

            MovieService movieService = dataManager.movie();

            Response<GenreList> list = movieService.genres().execute();

            return list.isSuccessful() ? list.body() : null;

        }).filter(r -> r != null)
                .subscribeOn(Schedulers.io())
                .subscribe(list::postValue);


        disposable.add(d);
    }


    @Override
    protected void onCleared() {
        disposable.dispose();
        super.onCleared();
    }
}
