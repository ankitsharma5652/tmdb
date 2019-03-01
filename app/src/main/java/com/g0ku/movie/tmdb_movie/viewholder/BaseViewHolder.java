package com.g0ku.movie.tmdb_movie.viewholder;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.repo.MovieRepository;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public  class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);


        dataManager  = ((MyApplication)itemView.getContext().getApplicationContext()).component().dataManager();
        movieRepo  = ((MyApplication)itemView.getContext().getApplicationContext()).component().movieRepo();
    }

    private T data;

    protected DataManager dataManager;
    protected MovieRepository movieRepo;

    public  void onAttach(){}

    @CallSuper
    public void onBind(T data){
        this.data = data;
    }

    public  void onDetach(){}


    public void onRecycle(){}


    public void show(){ itemView.setVisibility(View.VISIBLE);}
    public void hide(){ itemView.setVisibility(View.GONE);}


    public T get(){return data;}
}
