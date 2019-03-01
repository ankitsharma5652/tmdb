package com.g0ku.movie.tmdb_movie.model.remote.response;

import com.g0ku.movie.tmdb_movie.pojo.Genre;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreList {


    @SerializedName("genres")
    private List<Genre> genreList;

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}
