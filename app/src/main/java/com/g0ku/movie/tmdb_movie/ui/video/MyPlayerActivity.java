package com.g0ku.movie.tmdb_movie.ui.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.g0ku.movie.tmdb_movie.R;
import com.jaedongchicken.ytplayer.YoutubePlayerView;

public class MyPlayerActivity extends AppCompatActivity  {

    YoutubePlayerView player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_player);


        // Grabs a reference to the player view
        player =  findViewById(R.id.player);


        player.initialize(null,null);


    }

}
