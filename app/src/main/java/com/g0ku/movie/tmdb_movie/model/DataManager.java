package com.g0ku.movie.tmdb_movie.model;

import android.content.Context;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.model.remote.ConfigurationService;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.PeopleService;
import com.g0ku.movie.tmdb_movie.model.remote.response.ConfigurationResult;
import com.g0ku.movie.tmdb_movie.pojo.ImageConfiguration;
import com.g0ku.movie.tmdb_movie.service.CastService;

import com.g0ku.movie.tmdb_movie.model.remote.ConfigurationService;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.model.remote.response.ConfigurationResult;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

import javax.inject.Inject;

import retrofit2.Retrofit;


public class DataManager {


    private final Context context;

    private final Retrofit retrofit;

    private final Gson gson;


    @Inject
    public DataManager(Context context, Retrofit retrofit, Gson gson) {
        this.context = context.getApplicationContext();
        this.retrofit = retrofit;
        this.gson = gson;


    }


    public Retrofit network() {
        return retrofit;
    }

    public MovieService movie() {
        return network().create(MovieService.class);
    }
    public CastService cast() {
        return network().create(CastService.class);
    }

    public ConfigurationService config() {
        return network().create(ConfigurationService.class);
    }


    public void saveImageConfig(ConfigurationResult imageConfiguration) {

        if (imageConfiguration == null) return;

        File file = new File(context.getExternalCacheDir(), context.getString(R.string.img_conf));
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.append(gson.toJson(imageConfiguration));
        } catch (IOException e) {
        }
    }


    public  ConfigurationResult imageConfig(){
        File file = new File(context.getFilesDir(), context.getString(R.string.img_conf));

        ConfigurationResult imageConfiguration = null;
        try(FileInputStream reader = new FileInputStream(file)){

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int count  = - 1;
            byte []read = new byte[1024];

            while((count = reader.read(read)) != -1)
                out.write(read,0,count);

            imageConfiguration = gson.fromJson(out.toString(),ConfigurationResult.class);

        }catch (IOException e){ imageConfiguration = null;}

        return imageConfiguration;
    }


    public PeopleService people() {
        return retrofit.create(PeopleService.class);
    }
}
