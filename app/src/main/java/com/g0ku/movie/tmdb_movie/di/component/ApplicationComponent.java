package com.g0ku.movie.tmdb_movie.di.component;

import com.g0ku.movie.tmdb_movie.di.module.ApplicationModule;
import com.g0ku.movie.tmdb_movie.di.module.NetworkModule;
import com.g0ku.movie.tmdb_movie.di.scope.ApplicationScope;
import com.g0ku.movie.tmdb_movie.model.DataManager;
import com.g0ku.movie.tmdb_movie.model.repo.MovieRepository;
import com.g0ku.movie.tmdb_movie.ui.home.HomeFragment;

import com.g0ku.movie.tmdb_movie.viewmodel.VideoListViewModel;

import dagger.Component;
import dagger.Subcomponent;

@ApplicationScope
@Component(modules = {ApplicationModule.class,NetworkModule.class})
public interface ApplicationComponent {



    HomeFragmentComponent plus();



    DataManager dataManager();

    void inject(VideoListViewModel videoListFragment);

    MovieRepository movieRepo();


    @Subcomponent
    interface HomeFragmentComponent{

        void inject(HomeFragment homeFragment);
    }


}
