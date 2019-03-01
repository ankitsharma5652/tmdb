package com.g0ku.movie.tmdb_movie.model.remote.response;

import com.g0ku.movie.tmdb_movie.pojo.ImageConfiguration;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigurationResult {


    @SerializedName("images")
    private ImageConfiguration imageConfig;


    @SerializedName("change_keys")
    private List<String> changeKeys;


    public ImageConfiguration getImageConfig() {
        return imageConfig;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

}
