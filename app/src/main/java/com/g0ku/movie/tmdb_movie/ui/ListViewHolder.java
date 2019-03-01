package com.g0ku.movie.tmdb_movie.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.CastAdapter;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.service.CastResponse;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.pojo.Cast;

import java.util.List;

import io.reactivex.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListViewHolder {

    private View mView;

    private TextView mTitle;
    private RecyclerView mList;
    private CastAdapter mAdapter;
    private DataManager dataManager;
    private MutableLiveData<List<Cast>> casts;

    public ListViewHolder(View view) {
        this.mView = view;
        this.dataManager = ((MyApplication)view.getContext().getApplicationContext())
                                                        .component().dataManager();

        mList  = mView.findViewById(R.id.cast_list);
        mTitle  = mView.findViewById(R.id.title_cast);
        mAdapter = new CastAdapter();

        mList.setAdapter(mAdapter);

        mTitle.setText("Cast");

        casts = new MutableLiveData<>();


    }



    public void addCast(List<Cast> cast){
        mAdapter.addAll(cast);
    }


    public LiveData<List<Cast>> getCasts() {
        return casts;
    }

    public void fetch(Integer movie){
        dataManager.cast().movieCast(movie).enqueue(new Callback<CastResponse>() {
            @Override
            public void onResponse(@NonNull Call<CastResponse> call, @NonNull Response<CastResponse> response) {

                if(!response.isSuccessful()) return ;

                mAdapter.clear();
                 casts.setValue(response.body().getCast());
            }

            @Override
            public void onFailure(Call<CastResponse> call, Throwable t) {}
        });


    }
}
