package com.g0ku.movie.tmdb_movie.model.remote.response;

import com.g0ku.movie.tmdb_movie.pojo.Dates;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

import com.g0ku.movie.tmdb_movie.pojo.Dates;
import com.google.gson.annotations.SerializedName;

import java.util.Iterator;
import java.util.List;

public class MovieResult {


    @SerializedName("page")
    private Integer page;
    @SerializedName("total_results")
    private Integer totalResult;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("results")
    private List<Movie> movies;


    @SerializedName("dates")
    private Dates dates;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Iterator<Movie> getMovies() {
        return movies == null ? null : movies.iterator();
    }

    public List<Movie> movieList() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }



    public Dates getDates() {
        return dates;
    }
}
