package com.g0ku.movie.tmdb_movie.pojo;

import com.google.gson.annotations.SerializedName;

/*
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
 */
public class Video {


    public static final String YOUTUBE = "YouTube";

    @SerializedName("id")
    private String id;

    @SerializedName("iso_639_1")
    private String language;

    @SerializedName("iso_3166_1")
    private String languageCountry;

    @SerializedName("size")
    private String size;

    @SerializedName("key")
    private String key;

    @SerializedName("type")
    private String type;

    @SerializedName("name")
    private String name;

    @SerializedName("site")
    private String site;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageCountry() {
        return languageCountry;
    }

    public void setLanguageCountry(String languageCountry) {
        this.languageCountry = languageCountry;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }


    public static boolean isYoutube(String site){
        return YOUTUBE.equalsIgnoreCase(site);
    }
}

