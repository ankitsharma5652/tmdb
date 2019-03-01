package com.g0ku.movie.tmdb_movie.model.remote;

import com.g0ku.movie.tmdb_movie.pojo.People;
import com.g0ku.movie.tmdb_movie.pojo.PeopleImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface PeopleService {


    @GET("3/person/{person_id}")
    Call<People> detail(@Path("person_id")Integer personID);


    @GET("3/person/{person_id}/images")
    Call<PeopleImage> images(@Path("person_id")Integer personID);


}
