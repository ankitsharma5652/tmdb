package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("iso_3166_1")
    private String code;
    @SerializedName("english_name")
    private String name;
}
