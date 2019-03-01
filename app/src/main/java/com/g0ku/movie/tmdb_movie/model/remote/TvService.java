package com.g0ku.movie.tmdb_movie.model.remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TvService {

    @GET("/genre/tv/list")
    Call<ResponseBody> genre();

}
