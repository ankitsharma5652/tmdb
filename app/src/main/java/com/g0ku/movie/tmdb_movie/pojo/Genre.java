package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

/*
{
      "id": 27,
      "name": "Horror"
    }
 */
public class Genre {


    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
