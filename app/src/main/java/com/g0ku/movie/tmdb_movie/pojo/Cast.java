package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/*
{
      "cast_id": 5,
      "character": "Don Vito Corleone",
      "credit_id": "52fe422bc3a36847f8009357",
      "gender": 2,
      "id": 3084,
      "name": "Marlon Brando",
      "order": 0,
      "profile_path": "/vklkhX4QlRKnEG8ylhWzoBdcuev.jpg"

 */
public class Cast implements Serializable {


    @SerializedName("cast_id")
    private String castId;

    @SerializedName("character")
    private String character;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private String order;

    @SerializedName("profile_path")
    private String proflieImgPath;


    @SerializedName("id")
    private Integer id;

    @SerializedName("gender")
    private Integer gender;


    public String getCastId() {
        return castId;
    }

    public void setCastId(String castId) {
        this.castId = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getProflieImgPath() {
        return proflieImgPath;
    }

    public void setProflieImgPath(String proflieImgPath) {
        this.proflieImgPath = proflieImgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
