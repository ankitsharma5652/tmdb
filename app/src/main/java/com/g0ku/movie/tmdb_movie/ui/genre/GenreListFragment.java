package com.g0ku.movie.tmdb_movie.ui.genre;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.GenreAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentMovieListBinding;
import com.g0ku.movie.tmdb_movie.model.remote.response.GenreList;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;

public class GenreListFragment extends BaseFragment {


    public static final String TAG = "genre";
    private GenreListViewModel viewModel;

    private GenreAdapter mAdapter;
    private FragmentMovieListBinding listBinding;

    public static GenreListFragment newInstance() {

        Bundle args = new Bundle();

        GenreListFragment fragment = new GenreListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new GenreAdapter();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false);

        listBinding.list.setLayoutManager(new LinearLayoutManager(listBinding.getRoot().getContext()));
        listBinding.list.setHasFixedSize(true);

        return listBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity()).get(GenreListViewModel.class);

        listBinding.list.setAdapter(mAdapter);

        viewModel.getList().observe(this, this::updateList);
    }

    private void updateList(GenreList genreList) {

        if (genreList == null) return;

        mAdapter.addAll(genreList.getGenreList());
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel.fetchGenres();
    }
}
