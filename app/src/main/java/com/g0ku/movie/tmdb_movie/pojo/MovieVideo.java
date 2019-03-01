package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
{
  "id": 238,
  "results": [
    {
      "id": "592199669251414ab10568ec",
      "iso_639_1": "en",
      "iso_3166_1": "US",
      "key": "fBNpSRtfIUA",
      "name": "The Godfather- Offer He Can't Refuse",
      "site": "YouTube",
      "size": 1080,
      "type": "Clip"
    },
    {
      "id": "5b73e18f92514140681c2cba",
      "iso_639_1": "en",
      "iso_3166_1": "US",
      "key": "_IqFJLdV13o",
      "name": "The Godfather - Official® Trailer [HD]",
      "site": "YouTube",
      "size": 1080,
      "type": "Trailer"
    }
  ]
}
 */
public class MovieVideo {

    @SerializedName("id")
    private Integer id;

    @SerializedName("results")
    private List<Video> videos;

    public static boolean isEmpty(MovieVideo mList) {
        return mList == null || mList.getVideos() == null || mList.getVideos().isEmpty();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
