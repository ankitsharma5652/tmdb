package com.g0ku.movie.tmdb_movie.pojo;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class HomeItem {


    public static final int TRENDING_DAY = 7;
    public static final int TRENDING_WEEK = 8;
    public static final int SIMILAR = 9;
    public static final int SEARCH = 10;
    private String title;



    private int type = NONE;


    public static final int NONE=1;
    public static final int POPULAR=2;
    public static final int LATEST=3;
    public static final int TOP_RATED=4;
    public static final int UPCOMING=5;
    public static final int BANNER = 6;


    @Retention(RetentionPolicy.SOURCE)
    @IntDef({NONE,POPULAR,LATEST,TOP_RATED,SIMILAR,UPCOMING,BANNER,TRENDING_DAY,TRENDING_WEEK})
    public @interface Type{}


    public HomeItem(String title,@Type int type) {
        this.title = title;
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Type
    public int getType() {
        return type;
    }

    public void setType(@Type int type) {
        this.type = type;
    }


}


