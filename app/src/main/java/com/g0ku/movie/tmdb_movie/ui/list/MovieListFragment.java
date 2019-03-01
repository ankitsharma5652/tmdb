package com.g0ku.movie.tmdb_movie.ui.list;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.HomeAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentMovieListBinding;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.remote.response.MovieResult;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends BaseFragment  {

    public static final String TAG = "movie_list";
    private static final String MOVIE_ID = "movie_id";
    private FragmentMovieListBinding listBinding;

    private MovieListViewModel viewModel;

    private HomeAdapter mAdapter;
    DataManager dataManager;


    public MovieListFragment() {
        // Required empty public constructor
    }

    public static MovieListFragment newInstance(int intExtra) {

        Bundle args = new Bundle();

        args.putInt(MovieListActivity.ITEM,intExtra);
        MovieListFragment fragment = new MovieListFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie_list,container,false);


        return listBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);

        mAdapter = new HomeAdapter();
        listBinding.list.setAdapter(mAdapter);
        ((GridLayoutManager)listBinding.list.getLayoutManager()).setSpanCount(getContext().getResources().getInteger(R.integer.list_column));


        viewModel.getMovieList().observe(getViewLifecycleOwner(),mAdapter::loadMore);

        viewModel.msg().observe(getViewLifecycleOwner(),this::showMessage);

        listBinding.list.addOnScrollListener(mListener);

        viewModel.setMovieID(getActivity().getIntent(),getArguments().getInt(MovieListActivity.ITEM));
        viewModel.setDataManager(dataManager);
        viewModel.fetchMovie();


        viewModel.getIsLoading().observe(this,mAdapter::setLoading);
    }



    @Override
    public void inject(ApplicationComponent component) {

        dataManager = component.dataManager();
    }

    private void showMessage(String s) {

        if(TextUtils.isEmpty(s)) return;

        Snackbar.make(getView(),s,Snackbar.LENGTH_LONG);
    }


    private RecyclerView.OnScrollListener mListener = new RecyclerView.OnScrollListener(){
        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

            GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();

            if(manager == null) return;

            int total  = manager.getItemCount();
            int first = manager.findFirstVisibleItemPosition();
            int last = manager.findLastVisibleItemPosition();


            boolean startLoad = total <= last + 10;

            if(startLoad )
                viewModel.loadMore();


        }
    };
}
