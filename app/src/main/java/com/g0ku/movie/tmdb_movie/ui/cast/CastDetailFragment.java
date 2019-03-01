package com.g0ku.movie.tmdb_movie.ui.cast;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.adapter.PeopleImagePagerAdapter;
import com.g0ku.movie.tmdb_movie.databinding.FragmentCastDetailBinding;
import com.g0ku.movie.tmdb_movie.di.component.ApplicationComponent;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.pojo.People;
import com.g0ku.movie.tmdb_movie.pojo.PeopleImage;
import com.g0ku.movie.tmdb_movie.ui.BaseFragment;

import javax.inject.Inject;


public class CastDetailFragment extends BaseFragment {

    public static final String TAG = "cast_D";
    private FragmentCastDetailBinding mBinding;
    private static final String PEOPLE_ID = "pid";
    private CastDetailViewModel viewModel;

    private PeopleImagePagerAdapter mAdapter ;
    @Inject
    DataManager dataManager;



    public static CastDetailFragment newInstance(Cast cast) {

        Bundle args = new Bundle();
        args.putSerializable(PEOPLE_ID,cast);

        CastDetailFragment fragment = new CastDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_cast_detail,container,false);

        viewModel = ViewModelProviders.of(this).get(CastDetailViewModel.class);

        mAdapter = new PeopleImagePagerAdapter();
        return mBinding.getRoot();
    }


    @Override
    public void inject(ApplicationComponent component) {

        dataManager = component.dataManager();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        if(getArguments() == null || !getArguments().containsKey(PEOPLE_ID)){
            getActivity().finish();
            return;
        }




        Cast cast = (Cast) getArguments().getSerializable(PEOPLE_ID);
        if(cast == null){

            getActivity().finish();
            return;
        }

        viewModel.setCast(cast);


        viewModel.getPeople().observe(getViewLifecycleOwner(),this::updatePeople);
        viewModel.getPeopleImage().observe(getViewLifecycleOwner(),this::updatePeopleImage);

        viewModel.fetchDetail(dataManager);

        mBinding.peopleImg.setAdapter(mAdapter);


    }

    private void updatePeopleImage(PeopleImage peopleImage) {

        mAdapter.loadMore(peopleImage.getPeopleImgs());

    }

    private void updatePeople(People people) {

        if(people == null) return;

        mBinding.setPeople(people);

        viewModel.fetchImages(dataManager);
    }
}
