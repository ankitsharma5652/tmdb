package com.g0ku.movie.tmdb_movie.model.remote;

import com.g0ku.movie.tmdb_movie.model.remote.response.GenreList;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;

import com.g0ku.movie.tmdb_movie.model.remote.response.GenreList;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.MovieVideo;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface MovieService {



    @GET("movie/{movie_id}")
    Call<ResponseBody> detail(@Path("movie_id") Integer movieID);


    @GET("3/movie/latest")
    Call<MovieResult> latest();


    @GET("3/movie/top_rated")
    Call<MovieResult> topRated();


    @GET("3/movie/upcoming")
    Call<MovieResult> upcoming();


    @GET("3/movie/latest")
    Call<MovieResult> latest(@Query("page")Integer page);


    @GET("3/movie/top_rated")
    Call<MovieResult> topRated(@Query("page")Integer page);


    @GET("3/movie/upcoming")
    Call<MovieResult> upcoming(@Query("page")Integer page);

    @GET("3/movie/popular")
    Call<MovieResult> popular(@Query("page")Integer page);


    @GET("3/trending/{media_type}/{time_window}")
    Call<MovieResult> trending(@Path("media_type")String mediaType,@Path("time_window")String time_window);

    @GET("3/genre/movie/list")
    Call<GenreList> genres();


    @GET("3/movie/{movie_id}/videos")
    Call<MovieVideo> movieVideo(@Path("movie_id") Integer movieID);


    @GET("3/movie/{movie_id}/similar")
    Call<MovieResult> similar(@Path("movie_id")String movieID);

    @GET("3/discover/movie")
    Call<MovieResult> searchGenres(@QueryMap HashMap<String,String> genres);



    @GET("3/search/movie")
    Call<MovieResult> search(@QueryMap HashMap<String,String> genres);



}


