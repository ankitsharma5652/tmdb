package com.g0ku.movie.tmdb_movie.model.remote;

import com.g0ku.movie.tmdb_movie.model.remote.response.ConfigurationResult;
import com.g0ku.movie.tmdb_movie.pojo.Country;
import com.g0ku.movie.tmdb_movie.pojo.ImageConfiguration;

import com.g0ku.movie.tmdb_movie.model.remote.response.ConfigurationResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ConfigurationService {


    @GET("3/configuration")
    Call<ConfigurationResult> configuration();

    @GET("3/config/countries")
    Call<List<Country>> countries();
}
