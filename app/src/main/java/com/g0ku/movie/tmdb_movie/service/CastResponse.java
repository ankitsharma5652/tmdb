package com.g0ku.movie.tmdb_movie.service;

import com.g0ku.movie.tmdb_movie.pojo.Cast;

import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CastResponse {


    @SerializedName("id")
    private String id;

    @SerializedName("cast")
    private List<Cast> cast;


    public String getId() {
        return id;
    }

    public List<Cast> getCast() {
        return cast;
    }
}
