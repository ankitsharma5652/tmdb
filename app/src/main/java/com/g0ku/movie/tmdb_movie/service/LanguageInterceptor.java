package com.g0ku.movie.tmdb_movie.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.g0ku.movie.tmdb_movie.R;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LanguageInterceptor implements Interceptor {

    private static final String LANGUAGE = "language";

    private Context ctx;

    public LanguageInterceptor(Context ctx) {
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        HttpUrl request= chain.request()
                .url().newBuilder().addQueryParameter(LANGUAGE,"en-US").build();

        return chain.proceed(chain.request().newBuilder().url(request).build());
    }
}
