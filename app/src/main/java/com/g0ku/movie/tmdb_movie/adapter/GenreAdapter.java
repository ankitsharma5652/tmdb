package com.g0ku.movie.tmdb_movie.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.Genre;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.pojo.Movie;
import com.g0ku.movie.tmdb_movie.ui.list.MovieListActivity;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    private List<Genre> mList;

    public GenreAdapter() {
        this.mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GenreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_activated_1,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder viewHolder, int position) {

        viewHolder.update(mList.get(position));


    }


    public void addAll(List<Genre> list){
        if(list == null || list.isEmpty()) return;

        int size  = mList.size();
        mList.clear();

        notifyItemRangeRemoved(0,size);
        mList.addAll(list);

        notifyItemRangeInserted(0,list.size());
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private Genre genre;

        GenreViewHolder(@NonNull View itemView) {
            super(itemView);

            TypedValue outValue = new TypedValue();
            itemView.getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            itemView.setBackgroundResource(outValue.resourceId);

            textView = itemView.findViewById(android.R.id.text1);


            textView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {

            if(genre == null){
                Snackbar.make(v,"No Information found...",Snackbar.LENGTH_SHORT).show();
                return;
            }
            Snackbar.make(v,"ID is "+textView.getText().toString(),Snackbar.LENGTH_LONG);

            v.getContext().startActivity(new Intent(v.getContext(),MovieListActivity.class)
                        .putExtra(MovieListActivity.ITEM,HomeItem.SEARCH)
                .putExtra(MovieListActivity.GENRES,genre.getId().toString()));
        }

        public void update(Genre genre) {

                this.genre =genre;

                if(getAdapterPosition() == RecyclerView.NO_POSITION) return;


                textView.setText(genre.getName());

        }
    }


}
