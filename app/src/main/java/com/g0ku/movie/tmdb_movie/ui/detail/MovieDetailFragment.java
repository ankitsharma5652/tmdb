package com.g0ku.movie.tmdb_movie.ui.detail;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import com.g0ku.movie.tmdb_movie.adapter.ImagePagerAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentMovieDetailBinding;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;
import com.g0ku.movie.tmdb_movie.ui.ListViewHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.viewholder.HomeItemViewHolder;
import com.g0ku.movie.tmdb_movie.viewholder.MovieInfoViewHolder;


import java.util.Collections;

import io.reactivex.annotations.NonNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends BaseFragment {


    public static final String TAG = "detail";
    private MovieDetailViewModel viewModel;
    private FragmentMovieDetailBinding detailBinding;

    private ImagePagerAdapter mViewPagerAdapter;
    private ListViewHolder movieCast;



    public MovieDetailFragment() {
    }


    public static MovieDetailFragment newInstance(Movie movie) {

        Bundle args = new Bundle();

        args.putSerializable(Movie.TAG,movie);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel.class);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        detailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_detail,container,false);

        return detailBinding.getRoot();
    }

    private void setupCast(View movieCastView) {

        movieCast = new ListViewHolder(movieCastView);

        movieCast.getCasts().observe(getViewLifecycleOwner(),movieCast::addCast);

    }


    @Override
    public void onViewCreated(@android.support.annotation.NonNull View view, @Nullable Bundle savedInstanceState) {

        if((getArguments() == null || !getArguments().containsKey(Movie.TAG))  && getFragmentManager() != null)
        {
            getFragmentManager().popBackStack();
            return;
        }

        View movieCast = detailBinding.getRoot().findViewById(R.id.cast);


        setupCast(movieCast);

        mViewPagerAdapter = new ImagePagerAdapter();
        mViewPagerAdapter.setShowTitle(false);



        viewModel.getMovie().observe(getViewLifecycleOwner(),this::updateMovie);


        if(getArguments() != null )
        {
           Movie movie = (Movie) getArguments().getSerializable(Movie.TAG);

            viewModel.setMovie(movie);

        }


    }

    private void fetchSimilarMovie() {

        HomeItemViewHolder viewHolder = new HomeItemViewHolder(detailBinding.getRoot().findViewById(R.id.similar_movie));

        viewHolder.onBind(new HomeItem("Similar Movie",HomeItem.SIMILAR),viewModel.getMovie().getValue().getId().toString());
    }


    private void updateMovie(@Nullable Movie movie) {
        if(movie == null) return;

        detailBinding.setMovie(movie);

        mViewPagerAdapter.addAll(Collections.singletonList(movie));

        detailBinding.viewpager.setAdapter(mViewPagerAdapter);

        movieCast.fetch(movie.getId());
        fetchSimilarMovie();
        fetchMovieInfo();


    }

    private void fetchMovieInfo() {

        MovieInfoViewHolder viewHolder = new MovieInfoViewHolder(detailBinding.detail);
        viewHolder.onBind(viewModel.getMovie().getValue());
    }

}
