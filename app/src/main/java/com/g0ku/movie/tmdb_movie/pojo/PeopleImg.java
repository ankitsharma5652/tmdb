package com.g0ku.movie.tmdb_movie.pojo;


import com.google.gson.annotations.SerializedName;

/*
 {
      "iso_639_1": null,
      "width": 720,
      "height": 1080,
      "vote_count": 6,
      "vote_average": 5.162,
      "file_path": "/vhByt7dx3m88UUf5P2NgK7dqqW6.jpg",
      "aspect_ratio": 0.66666666666667
    }
 */
public class PeopleImg {


    @SerializedName("iso_639_1")
    private String iso;

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("vote_average")
    private Integer voteAverage;

    @SerializedName("file_path")
    private String filePath;

    @SerializedName("aspect_ratio")
    private String aspectRatio;


    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
}
