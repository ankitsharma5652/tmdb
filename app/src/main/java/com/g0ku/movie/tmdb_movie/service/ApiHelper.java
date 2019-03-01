package com.g0ku.movie.tmdb_movie.service;

import com.g0ku.movie.tmdb_movie.model.DataManager;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class ApiHelper {

    private final DataManager dataManager;

    public ApiHelper(DataManager dataManager) {
        this.dataManager = dataManager;
    }




    public void saveConfiguration(){

        Disposable disposable = Observable.fromCallable(() -> dataManager.config().configuration().execute())
                .filter(r -> r.isSuccessful())
                .map(s -> s.body())
                .subscribe(dataManager::saveImageConfig);
    }
}
