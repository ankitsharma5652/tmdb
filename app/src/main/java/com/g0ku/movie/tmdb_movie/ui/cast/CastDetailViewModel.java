package com.g0ku.movie.tmdb_movie.ui.cast;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.PeopleService;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.pojo.People;
import com.g0ku.movie.tmdb_movie.pojo.PeopleImage;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableAll;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CastDetailViewModel extends ViewModel {


    private MutableLiveData<Cast> cast = new MutableLiveData<>();

    private MutableLiveData<People> people = new MutableLiveData<>();
    private MutableLiveData<PeopleImage> peopleImage = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();


    public LiveData<Cast> getCast() {
        return cast;
    }


    public void setCast(Cast cast){
        this.cast.setValue(cast);
    }




    public void fetchDetail(DataManager dataManager){

        if(cast == null) return;

        if(people.getValue() != null){
            people.setValue(people.getValue());
            return;
        }


        Disposable d = Single.fromCallable(()->{
            PeopleService service =  dataManager.people();

            Response<People> response  = service.detail(cast.getValue().getId()).execute();

            return response.isSuccessful() ? response.body() : null;
        })
                .subscribeOn(Schedulers.io())
                .filter(s -> s != null)
                .subscribe(people::postValue);


        disposable.add(d);
    }


    public void fetchImages(DataManager dataManager){
     Integer id =  people.getValue().getId();

        Disposable d = Single.fromCallable(()->{
            PeopleService service =  dataManager.network().create(PeopleService.class);

            Response<PeopleImage> response  = service.images(id).execute();

            return response.isSuccessful() ? response.body() : null;
        })
                .subscribeOn(Schedulers.io())
                .filter(s -> s != null)
                .subscribe(peopleImage::postValue,e->{});


        disposable.add(d);

    }

    public LiveData<PeopleImage> getPeopleImage() {
        return peopleImage;
    }

    public LiveData<People> getPeople() {
        return people;
    }

    @Override
    protected void onCleared() {
        if(!disposable.isDisposed())
            disposable.dispose();

        super.onCleared();
    }
}
