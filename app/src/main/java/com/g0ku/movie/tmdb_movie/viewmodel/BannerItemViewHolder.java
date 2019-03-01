package com.g0ku.movie.tmdb_movie.viewmodel;

import com.g0ku.movie.tmdb_movie.MyApplication;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.ImagePagerAdapter;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.Trending;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.viewholder.BaseViewHolder;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.g0ku.movie.tmdb_movie.adapter.ImagePagerAdapter;
import com.g0ku.movie.tmdb_movie.model.remote.Trending;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;

import javax.inject.Inject;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerItemViewHolder extends BaseViewHolder<HomeItem>{

    private ViewPager viewPager;
    private ImagePagerAdapter mAdapter;

    private CircleIndicator indicatorView;


    public BannerItemViewHolder(@NonNull View itemView) {
        super(itemView);

        viewPager = itemView.findViewById(R.id.viewpager);
        indicatorView = itemView.findViewById(R.id.indicator);

        indicatorView.setViewPager(viewPager);

        mAdapter = new ImagePagerAdapter();

        viewPager.setAdapter(mAdapter);



    }

    @Override
    public void onBind(HomeItem data) {
        super.onBind(data);

        if(mAdapter.getCount() == 0)
        callService(data.getType());
    }

    @Override
    public void onAttach() {

    }

    @Override
    public void onDetach() {

    }


    public void callService(int type){

        MovieService service = dataManager.movie();
        switch (type){

            case HomeItem.TRENDING_DAY:
                fetch(service.trending("movie",Trending.TRENDING_DAY));
                break;
            case HomeItem.TRENDING_WEEK:
                fetch(service.trending("movie",Trending.TRENDING_WEEK));


        }

    }

    private void fetch(Call<MovieResult> movie) {


        movie.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(@NonNull Call<MovieResult> call, @NonNull Response<MovieResult> response) {
                if(!response.isSuccessful()) return;

                if(response.body() != null)
                    mAdapter.addAll(response.body().movieList());

                itemView.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(@NonNull Call<MovieResult> call, @NonNull Throwable t) {

                itemView.setVisibility(View.GONE);

            }
        });
    }

}
