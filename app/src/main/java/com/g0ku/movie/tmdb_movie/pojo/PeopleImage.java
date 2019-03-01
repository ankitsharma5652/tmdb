package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleImage {

    @SerializedName("profiles")
    private List<PeopleImg> peopleImgs;


    @SerializedName("id")
    private String peopleID;


    public List<PeopleImg> getPeopleImgs() {
        return peopleImgs;
    }

    public void setPeopleImgs(List<PeopleImg> peopleImgs) {
        this.peopleImgs = peopleImgs;
    }

    public String getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(String peopleID) {
        this.peopleID = peopleID;
    }
}
