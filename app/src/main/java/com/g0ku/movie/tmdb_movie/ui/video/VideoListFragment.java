package com.g0ku.movie.tmdb_movie.ui.video;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.g0ku.movie.tmdb_movie.adapter.VideoAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentVideoListBinding;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;
import com.g0ku.movie.tmdb_movie.viewmodel.VideoListViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoListFragment extends BaseFragment {


    private FragmentVideoListBinding mBinding;
    private VideoAdapter mAdapter;
    private VideoListViewModel viewModel;

    public VideoListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new VideoAdapter();
    }

    public static VideoListFragment newInstance(Movie movie) {

        Bundle args = new Bundle();

        VideoListFragment fragment = new VideoListFragment();
        args.putSerializable(Movie.TAG, movie);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentVideoListBinding.inflate(inflater, container, false);


        viewModel = ViewModelProviders.of(this).get(VideoListViewModel.class);


        return mBinding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        viewModel.fetchMovie(getArguments());

        mBinding.videoList.setAdapter(mAdapter);

        viewModel.getMovieVideo().observe(this,movieVideo -> {

            if(movieVideo == null || movieVideo.getVideos().isEmpty())
                showEmptyList();
                else
                mAdapter.setMovieVideo(movieVideo);

        });



        viewModel.fetchVideo();

    }

    private void showEmptyList() {

        mBinding.noVideo.setVisibility(View.VISIBLE);
        mBinding.videoList.setVisibility(View.GONE);

    }
}
