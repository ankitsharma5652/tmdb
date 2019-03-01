package com.g0ku.movie.tmdb_movie.util;

import android.databinding.BindingAdapter;

import com.jaedongchicken.ytplayer.YoutubePlayerView;

public class BindAdapterUtil {

    @BindingAdapter("video_id")
    public static void setVideoID(YoutubePlayerView youtubePlayerView,String videoId){
        if(videoId == null || videoId.isEmpty()) return;

        youtubePlayerView.initialize(videoId,null);
    }
}
