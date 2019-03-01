package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
 {
  "birthday": "1979-08-01",
  "known_for_department": "Acting",
  "deathday": null,
  "id": 117642,
  "name": "Jason Momoa",
  "also_known_as": [
    "杰森·莫玛",
    "제이슨 모모아",
    "Джейсон Момоа"
  ],
  "gender": 2,
  "biography": "Joseph Jason Namakaeha Momoa (born August 1, 1979) is a Kānaka-American actor, model, and producer. He is known for his television roles as Ronon Dex on the military science fiction television series Stargate Atlantis (2004–2009), Khal Drogo in the HBO fantasy television series Game of Thrones (2011–2012), and Declan Harp in the Netflix series Frontier (2016–present). He is also known in the DC Extended Universe as the character Aquaman.",
  "popularity": 32.327,
  "place_of_birth": "Honolulu, Hawaii, USA",
  "profile_path": "/pG1Faei9M8ObR4bOD2ljiSVuaDm.jpg",
  "adult": false,
  "imdb_id": "nm0597388",
  "homepage": null
}
*/
public class People {

    @SerializedName("birthday")
    private String dob;
    @SerializedName("known_for_department")
    private String knownForDepartment;
    @SerializedName("deathday")
    private String deathDay;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("also_known_as")
    private List<String> alias;
    @SerializedName("gender")
    private Integer gender;
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("place_of_birth")
    private String placeOfBirth;
    @SerializedName("profile_path")
    private String profilePath;
    @SerializedName("adult")
    private Boolean adult;
    @SerializedName("imdb_id")
    private String imdbID;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("biography")
    private String biography;


    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(String deathDay) {
        this.deathDay = deathDay;
    }

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

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
