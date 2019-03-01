package com.g0ku.movie.tmdb_movie.viewholder;

import android.app.Activity;
import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.HomeAdapter;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.ui.list.MovieListActivity;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeItemViewHolder extends BaseViewHolder<HomeItem> {

    private TextView title;

    private TextView more;

    private RecyclerView mList;

    private HomeAdapter mAdapter;

    private String movieID;

    private int page = 1;


    public HomeItemViewHolder(@NonNull View itemView) {
        super(itemView);


        title = itemView.findViewById(R.id.title);
        mList = itemView.findViewById(R.id.movie);
        more = itemView.findViewById(R.id.more);


        mList.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mList.setHasFixedSize(true);

        mAdapter = new HomeAdapter();

        mList.setAdapter(mAdapter);

        more.setOnClickListener(v ->{
            if(get() == null) return;

            Intent moreMoviesIntent = new Intent(v.getContext(),MovieListActivity.class);
            moreMoviesIntent.putExtra(MovieListActivity.ITEM,get().getType());
            v.getContext().startActivity(moreMoviesIntent);
        });


    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onBind(HomeItem homeItem) {
        super.onBind(homeItem);

        title.setText(homeItem.getTitle());

        if (mAdapter.getItemCount() == 0)
            callService(homeItem.getType());

    }
    public void onBind(HomeItem homeItem,String movieID) {
        this.movieID = movieID;

        onBind(homeItem);
    }

    @Override
    public void onDetach() {

    }


    private void callService(int type) {


        MovieService service = dataManager.movie();



        switch (type) {

            case HomeItem.POPULAR:
                fetch(service.popular(page));
                break;
            case HomeItem.UPCOMING:
                fetch(service.upcoming());
                break;
            case HomeItem.TOP_RATED:
                fetch(service.topRated());
                break;
            case HomeItem.SIMILAR:
                if(TextUtils.isEmpty(movieID))
                    hide();
                else
                    fetch(service.similar(movieID));

        }
    }

    private void fetch(Call<MovieResult> movieList) {

        movieList.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                if (!itemView.isAttachedToWindow() || !response.isSuccessful()) return;

                MovieResult body = response.body();

                mAdapter.clear();
                if (body != null)
                    mAdapter.addAll(body.movieList());

                if(mAdapter.getItemCount() == 0 )
                    hide();
                else
                    show();

            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {

                if(getAdapterPosition() != RecyclerView.NO_POSITION)
                    hide();

            }
        });

    }


}
