package com.g0ku.movie.tmdb_movie.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CastService {


    @GET("3/movie/{movie_id}/credits")
    Call<CastResponse> movieCast(@Path("movie_id") Integer movieID);
}
