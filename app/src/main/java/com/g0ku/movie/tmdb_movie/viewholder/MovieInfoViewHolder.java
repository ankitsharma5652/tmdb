package com.g0ku.movie.tmdb_movie.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Movie;

public class MovieInfoViewHolder extends BaseViewHolder<Movie> {

    TextView mRatingTitle,mRating;
    TextView mDurationTitle,mDuration;
    TextView mReleaseDateTitle,mReleaseDate;

    public MovieInfoViewHolder(@NonNull View itemView) {
        super(itemView);

        View view  = itemView.findViewById(R.id.rating);

        mRatingTitle = view.findViewById(R.id.title);
        mRating= view.findViewById(R.id.value);

        mRatingTitle.setText(R.string.rating);

        view = itemView.findViewById(R.id.duration);

        mDurationTitle = view.findViewById(R.id.title);
        mDuration= view.findViewById(R.id.value);

        mDurationTitle.setText(R.string.duration);

//        view = itemView.findViewById(R.id.title);

        mReleaseDateTitle= view.findViewById(R.id.title);
        mReleaseDate= view.findViewById(R.id.value);

        mReleaseDateTitle.setText(R.string.release_date);

    }

    public void update(Movie movie){

        if(movie == null) return;

        mRating.setText(movie.getVoteAverage());

        mDuration.setText(movie.getPopularity());

        mReleaseDate.setText(movie.getReleaseDate());
    }

    @Override
    public void onBind(Movie data) {
        super.onBind(data);

        update(data);
    }
}
