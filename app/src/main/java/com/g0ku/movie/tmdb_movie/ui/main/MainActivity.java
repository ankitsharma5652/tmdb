package com.g0ku.movie.tmdb_movie.ui.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.ui.BaseActivity;
import com.g0ku.movie.tmdb_movie.ui.genre.GenreListFragment;
import com.g0ku.movie.tmdb_movie.ui.home.HomeFragment;
import com.g0ku.movie.tmdb_movie.ui.search.SearchFragment;

import java.util.List;

public class MainActivity extends BaseActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment = null;

        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();

        switch (item.getItemId()) {
            case R.id.navigation_home:

                if(!fragmentList.isEmpty() && fragmentList.get(fragmentList.size() - 1) instanceof HomeFragment)
                    return true;

                getSupportFragmentManager()
                        .popBackStack(HomeFragment.TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    fragment = new HomeFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, HomeFragment.TAG)
                        .addToBackStack(HomeFragment.TAG)
                        .commit();

                return true;
            case R.id.navigation_dashboard:

                if(!fragmentList.isEmpty() && fragmentList.get(fragmentList.size() - 1) instanceof SearchFragment)
                    return true;

                fragment = getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG);

                if (fragment == null)
                    fragment = SearchFragment.newInstance();

                getSupportFragmentManager()
                        .popBackStack(SearchFragment.TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, SearchFragment.TAG)
                        .addToBackStack(SearchFragment.TAG)
                        .commit();



                return true;
            case R.id.navigation_notifications:

                if(!fragmentList.isEmpty() && fragmentList.get(fragmentList.size() - 1) instanceof GenreListFragment)
                    return true;

                fragment = getSupportFragmentManager().findFragmentByTag(GenreListFragment.TAG);

                if (fragment == null)
                    fragment = GenreListFragment.newInstance();

                getSupportFragmentManager()
                        .popBackStack(HomeFragment.TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, GenreListFragment.TAG)
                        .addToBackStack(GenreListFragment.TAG)
                        .commit();

                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new HomeFragment(), HomeFragment.TAG)
                .commit();


    }


    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
        else
        super.onBackPressed();

    }
}
