package com.g0ku.movie.tmdb_movie.adapter;

import com.g0ku.movie.tmdb_movie.pojo.Video;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class VideoPagerAdapter extends PagerAdapter {


    private List<Video> videoList;

    public VideoPagerAdapter() {
        this.videoList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return videoList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {




        return null;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


}
