package com.g0ku.movie.tmdb_movie.di.module;

import android.content.Context;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.di.qualifer.PicassoCache;
import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.service.ApiHelper;
import com.g0ku.movie.tmdb_movie.service.HeadInterceptor;

import com.g0ku.movie.tmdb_movie.di.qualifer.PicassoCache;
import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;
import com.g0ku.movie.tmdb_movie.model.remote.MovieService;
import com.g0ku.movie.tmdb_movie.service.ApiHelper;
import com.g0ku.movie.tmdb_movie.service.HeadInterceptor;
import com.g0ku.movie.tmdb_movie.service.LanguageInterceptor;
import com.google.gson.Gson;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Add Dagger dependencies

@Module(includes = ApplicationModule.class)
public class NetworkModule {


    @ApplicationScope
    @Provides
    public Retrofit retrofit(Context ctx,OkHttpClient client,GsonConverterFactory gson) {
        return new Retrofit
                .Builder()
                .baseUrl(ctx.getString(R.string.url))
                .client(client)
                .addConverterFactory(gson)
                .build();
    }


    @ApplicationScope
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }


    @ApplicationScope
    @Provides
    public Gson gson(){
        return new Gson();
    }

    @ApplicationScope
    @Provides
    public Cache cache(Context ctx) {

        return new Cache(ctx.getCacheDir(), 10 * 1024 * 1024);

    }




    @ApplicationScope
    @Provides
    public OkHttpClient client(Context ctx,HeadInterceptor headInterceptor,LanguageInterceptor languageInterceptor) {
        return new OkHttpClient
                .Builder()
                .addInterceptor(headInterceptor)
                .addInterceptor(languageInterceptor)
                .cache(cache(ctx))
                .build();
    }


    @ApplicationScope
    @Provides
    public HeadInterceptor headInterceptor(Context ctx){
        return new HeadInterceptor(ctx);
    }


    @ApplicationScope
    @Provides
    public LanguageInterceptor languageInterceptor(Context ctx){
        return new LanguageInterceptor(ctx);
    }


    @ApplicationScope
    @Provides
    public DataManager provideDataManager(Context ctx, Retrofit retrofit,Gson gson) {
        return new DataManager(ctx, retrofit,gson);
    }


    @ApplicationScope
    @Provides
    public MovieService provideMovieService(Retrofit retrofit){
        return retrofit.create(MovieService.class);
    }



    @ApplicationScope
    @Provides
    public Picasso picasso(Context ctx, @PicassoCache com.squareup.picasso.Cache cache, Downloader downloader){
        return new Picasso.Builder(ctx)
                .downloader(downloader)
                .memoryCache(cache)
                .build();
    }


    @ApplicationScope
    @Provides
    public Downloader downloader(OkHttpClient client){
        return new OkHttp3Downloader(client);
    }

    @PicassoCache
    @ApplicationScope
    @Provides
    public com.squareup.picasso.Cache picassoCache(Context ctx){
        return new LruCache(ctx);
    }



    @ApplicationScope
    @Provides
    public ApiHelper apiHelper(DataManager manager){return new ApiHelper(manager);}
}
