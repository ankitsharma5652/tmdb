package com.g0ku.movie.tmdb_movie.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.databinding.LayoutCastRowBinding;
import com.g0ku.movie.tmdb_movie.pojo.Cast;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.pojo.Cast;
import com.g0ku.movie.tmdb_movie.ui.cast.CastDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {

    private List<Cast> casts;


    public CastAdapter() {
        this.casts = new ArrayList<>();
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CastViewHolder(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),R.layout.layout_cast_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder viewHolder, int position) {
        viewHolder.setCast(casts.get(position));
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }


    public void addAll(List<Cast> casts){
        if(casts == null || casts.isEmpty()) return;


        int init  = casts.size();
        this.casts.addAll(casts);

        notifyItemRangeInserted(init,casts.size());
    }

    public void clear() {
        casts.clear();
        notifyDataSetChanged();
    }

    static class CastViewHolder extends RecyclerView.ViewHolder{

       private LayoutCastRowBinding castRowBindng;
        public CastViewHolder(@NonNull LayoutCastRowBinding castRowBinding) {
            super(castRowBinding.getRoot());

            this.castRowBindng = castRowBinding;

            castRowBindng.castImg.setOnClickListener(v ->{
                if(getAdapterPosition() == RecyclerView.NO_POSITION || castRowBinding.getCast() == null) return;

                Snackbar.make(v,castRowBindng.getCast().getId().toString(),Snackbar.LENGTH_LONG);

                Intent intent= new Intent(v.getContext(),CastDetailActivity.class);
                intent.putExtra(CastDetailActivity.CAST,castRowBindng.getCast());
                v.getContext().startActivity(intent);
            });

        }

        public void setCast(Cast cast){
            castRowBindng.setCast(cast);



        }
    }
}
