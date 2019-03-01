package com.g0ku.movie.tmdb_movie.ui.home;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.HomeListAdapter;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;
import com.g0ku.movie.tmdb_movie.viewmodel.HomeViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.adapter.HomeListAdapter;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.viewmodel.HomeViewModel;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


public class HomeFragment extends BaseFragment {


    public static final String TAG = "tag";
    private RecyclerView mList;


    HomeViewModel viewModel;
    @Inject
    HomeListAdapter adapter;

    static int i = 0;

    public HomeFragment() {
        Log.d(TAG,i+"");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter.addAll(createList());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mList = view.findViewById(R.id.home_list);

        return view;
    }


    @Override
    public void inject(ApplicationComponent component) {
        component.plus().inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mList.setHasFixedSize(true);
        mList.setAdapter(adapter);



        viewModel.getLatestMovies().observe(getViewLifecycleOwner(), list -> {

            if (list == null) return;

            list.size();

        });


    }


    public List<HomeItem> createList() {

        return Arrays.asList(
                new HomeItem(null, HomeItem.TRENDING_DAY),
                new HomeItem("Popular", HomeItem.POPULAR)
                , new HomeItem("Latest", HomeItem.TRENDING_WEEK)
                , new HomeItem("Top Rated", HomeItem.TOP_RATED)
                , new HomeItem("Upcoming", HomeItem.UPCOMING));
//        itemList.add(new HomeItem("Populatr",HomeItem.));


    }
}
