package com.g0ku.movie.tmdb_movie.adapter;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.viewholder.BaseViewHolder;
import com.g0ku.movie.tmdb_movie.viewholder.HomeItemViewHolder;
import com.g0ku.movie.tmdb_movie.viewmodel.BannerItemViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.viewholder.BaseViewHolder;
import com.g0ku.movie.tmdb_movie.viewholder.HomeItemViewHolder;
import com.g0ku.movie.tmdb_movie.viewmodel.BannerItemViewHolder;

public class HomeAdapterFactory {


    public static BaseViewHolder create(ViewGroup parent, int viewType){

        BaseViewHolder viewHolder = null;
        View row;
        switch (viewType){

            case HomeItem.POPULAR:
            case HomeItem.LATEST:
            case HomeItem.TOP_RATED:
            case HomeItem.UPCOMING:
                row = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_list_row, parent, false);

                viewHolder = new HomeItemViewHolder(row);

                break;

            case HomeItem.BANNER:
            case HomeItem.TRENDING_WEEK:
            case HomeItem.TRENDING_DAY:

                row  = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner_row,parent,false);

                viewHolder = new BannerItemViewHolder(row);

        }

        return viewHolder;
    }

}
