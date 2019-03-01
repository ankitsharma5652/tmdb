package com.g0ku.movie.tmdb_movie.pojo;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


/*
* {
      "character": "Petra Arkanian",
      "credit_id": "52fe47b29251416c91072cd7",
      "poster_path": "/zHRNhCkrFEMoudPr0uics5WZe7j.jpg",
      "id": 80274,
      "video": false,
      "vote_count": 3241,
      "adult": false,
      "backdrop_path": "/ulmVm23hsiopEsgVksgdYJSVlWR.jpg",
      "genre_ids": [
        878,
        28,
        12{{
      "character": "Petra Arkanian",
      "credit_id": "52fe47b29251416c91072cd7",
      "poster_path": "/zHRNhCkrFEMoudPr0uics5WZe7j.jpg",
      "id": 80274,
      "video": false,
      "vote_count": 3241,
      "adult": false,
      "backdrop_path": "/ulmVm23hsiopEsgVksgdYJSVlWR.jpg",
      "genre_ids": [
        878,
        28,
        12
      ],
      "original_language": "en",
      "original_title": "Ender's Game",
      "popularity": 14.934,
      "title": "Ender's Game",
      "vote_average": 6.6,
      "overview": "Based on the classic novel by Orson Scott Card, Ender's Game is the story of the Earth's most gifted children training to defend their homeplanet in the space wars of the future.",
      "release_date": "2013-11-01"
    }
      "character": "Petra Arkanian",
      "credit_id": "52fe47b29251416c91072cd7",
      "poster_path": "/zHRNhCkrFEMoudPr0uics5WZe7j.jpg",
      "id": 80274,
      "video": false,
      "vote_count": 3241,
      "adult": false,
      "backdrop_path": "/ulmVm23hsiopEsgVksgdYJSVlWR.jpg",
      "genre_ids": [
        878,
        28,
        12
      ],
      "original_language": "en",
      "original_title": "Ender's Game",
      "popularity": 14.934,
      "title": "Ender's Game",
      "vote_average": 6.6,
      "overview": "Based on the classic novel by Orson Scott Card, Ender's Game is the story of the Earth's most gifted children training to defend their homeplanet in the space wars of the future.",
      "release_date": "2013-11-01"
    }
      ],
      "original_language": "en",
      "original_title": "Ender's Game",
      "popularity": 14.934,
      "title": "Ender's Game",
      "vote_average": 6.6,
      "overview": "Based on the classic novel by Orson Scott Card, Ender's Game is the story of the Earth's most gifted children training to defend their homeplanet in the space wars of the future.",
      "release_date": "2013-11-01"
    }
    */




/*
*   {
            "vote_count": 1904,
            "id": 19404,
            "video": false,
            "vote_average": 9.2,
            "title": "Dilwale Dulhania Le Jayenge",
            "popularity": 14.368,
            "poster_path": "/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg",
            "original_language": "hi",
            "original_title": "दिलवाले दुल्हनिया ले जायेंगे",
            "genre_ids": [
                35,
                18,
                10749
            ],
            "backdrop_path": "/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg",
            "adult": false,
            "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            "release_date": "1995-10-20"
        },
      */
public class Movie implements Serializable {

    public static final String TAG = "mOVI";

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("vote_average")
    private String voteAverage;
    @SerializedName("id")
    private Integer id;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("video")
    private Boolean video;

    @SerializedName("genre_ids")
    private List<Integer> genreIDs;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("adult")
    private Boolean adult;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public List<Integer> getGenreIDs() {
        return genreIDs;
    }

    public void setGenreIDs(List<Integer> genreIDs) {
        this.genreIDs = genreIDs;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "voteCount=" + voteCount +
                ", voteAverage='" + voteAverage + '\'' +
                ", id=" + id +
                ", originalLanguage='" + originalLanguage + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", title='" + title + '\'' +
                ", popularity='" + popularity + '\'' +
                ", video=" + video +
                ", genreIDs=" + genreIDs +
                ", backdropPath='" + backdropPath + '\'' +
                ", adult=" + adult +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }


}
