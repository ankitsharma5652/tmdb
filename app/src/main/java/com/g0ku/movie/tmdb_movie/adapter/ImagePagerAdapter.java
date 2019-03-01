package com.g0ku.movie.tmdb_movie.adapter;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.g0ku.movie.tmdb_movie.ui.detail.MovieDetailActivity;
import com.g0ku.movie.tmdb_movie.ui.detail.MovieDetailFragment;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {


    private List<Movie> mList;
    private boolean showTitle = true;

    public ImagePagerAdapter() {
        this.mList = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    public void setShowTitle(boolean showTitle){
        this.showTitle = showTitle;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.layout_image_row,container,false);

        Picasso.get().load("https://image.tmdb.org/t/p/w780"+ mList.get(position).getBackdropPath())
                .fit()
                .centerInside().into((ImageView) view.findViewById(R.id.image));

        if(showTitle)
        {
            ((TextView)view.findViewById(R.id.title)).setText(mList.get(position).getTitle());

            view.findViewById(R.id.image).setOnClickListener(v->{
                v.getContext().startActivity(new Intent(v.getContext(),MovieDetailActivity.class)
                .putExtra(Movie.TAG,mList.get(position)));
            });

        }

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }





    public void addAll(List<Movie> movies) {

        if(movies == null || movies.isEmpty()) return;

        mList.clear();
        mList.addAll(movies);
        notifyDataSetChanged();
    }
}
