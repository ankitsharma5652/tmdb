package com.g0ku.movie.tmdb_movie.adapter;

import android.app.Activity;
import android.content.Intent;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.detail.MovieDetailActivity;

import android.databinding.DataBindingUtil;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter {


    private List<Movie> mList;
    private int loaderPosition = -1;


    public HomeAdapter() {
        this.mList = new ArrayList<>();
    }


    public void addAll(List<Movie> movies){

        if(movies == null || movies.isEmpty()) return;

        int size = mList.size();
        this.mList.addAll(movies);


        notifyItemRangeInserted(size,movies.size());
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        View view;

        switch (viewType){

            case 0 :
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_loading,viewGroup,false);
                viewHolder = new LoadingViewHolder(view);
                break;

            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_movie_row,viewGroup,false);
                viewHolder = new HomeViewHolder(view);


        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if(viewHolder instanceof HomeViewHolder)
        ((HomeViewHolder)viewHolder).update(mList.get(position));


    }


    @Override
    public int getItemViewType(int position) {

        return this.loaderPosition  == -1 ? 1 : this.loaderPosition == position ? 0 : 1;
    }

    public void clear(){
        mList.clear();

        notifyDataSetChanged();
    }

    public void loadMore(List<Movie> movies) {


        if(movies == null || movies.isEmpty()) return;

        int positionStart = this.mList.size();
        this.mList.addAll(movies);

        notifyItemRangeInserted(positionStart,movies.size());
    }

    public void setLoading(Boolean loading) {
        if(loading == null) return;


        if(loading)
        {
            loaderPosition = mList.size();
            mList.add(new Movie());
            notifyItemInserted(loaderPosition);
        }
        else if(loaderPosition != -1)
        {
            mList.remove(mList.get(loaderPosition));
            notifyItemRemoved(loaderPosition);
            loaderPosition = -1;
        }

    }


    private static class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {


        TextView title;
        TextView rating;
        CardView cardView;
        ImageView imageView;
        Movie movie;

        private HomeViewHolder(@NonNull View itemView) {
            super(itemView);


            cardView= itemView.findViewById(R.id.movie_card);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            imageView= itemView.findViewById(R.id.img);

            cardView.setOnClickListener(this);
            cardView.setOnLongClickListener(this);

        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setRating(String rating) {
            this.rating.setText(rating);
        }


        public void update(Movie movie){

            this.movie = movie;
            setTitle(movie.getTitle());
            setRating(movie.getVoteAverage());
            setImage(movie.getPosterPath());
        }

        private void setImage(String posterPath) {

            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500"+posterPath)
                    .fit()
                    .centerInside()
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {


            if(movie == null || getAdapterPosition() == RecyclerView.NO_POSITION ) return;


            Intent intent = new Intent(v.getContext(),MovieDetailActivity.class);

            intent.putExtra(Movie.TAG,movie);
//            ActivityOptionsCompat options = ActivityOptionsCompat.
//                    makeSceneTransitionAnimation((Activity) v.getContext(), imageView, "poster");
            v.getContext().startActivity(intent);//,options.toBundle());

        }

        @Override
        public boolean onLongClick(View v) {


            if(!v.isAttachedToWindow() || movie == null) return false;

            Snackbar.make(v,movie.getId().toString(),Snackbar.LENGTH_LONG);

            return false;
        }
    }


    private static class LoadingViewHolder extends RecyclerView.ViewHolder{
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
