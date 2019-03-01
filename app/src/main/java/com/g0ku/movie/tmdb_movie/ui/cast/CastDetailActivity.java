package com.g0ku.movie.tmdb_movie.ui.cast;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.ui.BaseActivity;

public class CastDetailActivity extends BaseActivity {


    public static final String CAST ="CAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cast_detail);


        Intent castIntent = getIntent();

        if(castIntent == null || !castIntent.hasExtra(CAST)){
            Snackbar.make(findViewById(android.R.id.content),"Failed to get cast",Snackbar.LENGTH_LONG).show();
            finish();
            return;
        }


        Cast cast = (Cast) getIntent().getSerializableExtra(CAST);

        Fragment f = CastDetailFragment.newInstance(cast);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.cast_detail,f,CastDetailFragment.TAG)
                .commit();

    }
}
