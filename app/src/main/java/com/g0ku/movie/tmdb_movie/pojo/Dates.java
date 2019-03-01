package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

public class Dates {

    //FORMAT => 2018-11-11
    public static final String FORMAT ="yyyy-MM-dd";


    @SerializedName("maximum")
    private String maximum;

    @SerializedName("minimum")
    private String minimum;
}
