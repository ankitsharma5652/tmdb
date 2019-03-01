package com.g0ku.movie.tmdb_movie.util;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtil {



    @BindingAdapter("bannerImg")
    public static void setImage(ImageView imageView,String posterPath){
        Picasso.get().load("https://image.tmdb.org/t/p/original"+posterPath).fit().centerInside().into(imageView);
    }


    @BindingAdapter("circleImg")
    public static void setCircleImage(ImageView imageView,String posterPath){
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+posterPath).into(imageView);
    }


}
