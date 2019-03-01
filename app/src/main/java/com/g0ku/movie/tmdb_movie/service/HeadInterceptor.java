package com.g0ku.movie.tmdb_movie.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.R;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.CallServerInterceptor;
import retrofit2.Retrofit;

public class HeadInterceptor implements Interceptor{


    private final String API_KEY ="api_key";
    private final String LANGUAGE="language";

    private Context ctx;
    public HeadInterceptor(Context ctx) {
        this.ctx = ctx.getApplicationContext();
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        HttpUrl request= chain.request()
                .url().newBuilder().addQueryParameter(API_KEY,ctx.getString(R.string.key)).build();

        return chain.proceed(chain.request().newBuilder().url(request).build());

    }


}
