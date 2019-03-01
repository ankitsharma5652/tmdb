package com.g0ku.movie.tmdb_movie.ui.search;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.HomeAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentSearchBinding;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {


    public static final String TAG = "sear";
    private SearchViewModel viewModel;
    private FragmentSearchBinding mBinding;
    private HomeAdapter mAdapter;



    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new HomeAdapter();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        viewModel = ViewModelProviders.of(getActivity()).get(SearchViewModel.class);

        mBinding = FragmentSearchBinding.inflate(inflater,container,false);
    return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mBinding.list.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mBinding.list.addOnScrollListener(mListener);

        mBinding.search.setOnQueryTextListener(search);

        viewModel.getMovieList().observe(this,mAdapter::addAll);
    }


    SearchView.OnQueryTextListener search = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            if(!TextUtils.isEmpty(query.trim()) ){

                viewModel.startSearch(query);

                return true;
            }

            return false;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            return false;
        }
    };

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
