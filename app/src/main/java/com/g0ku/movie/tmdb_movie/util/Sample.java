package com.g0ku.movie.tmdb_movie.util;

import android.content.Context;

import javax.inject.Inject;

public class Sample {


    Context ctx;

    @Inject
    public Sample(Context ctx) {
        this.ctx = ctx;
    }
}
