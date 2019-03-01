package com.g0ku.movie.tmdb_movie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.g0ku.movie.tmdb_movie.databinding.LayoutVideoRowBinding;
import com.g0ku.movie.tmdb_movie.pojo.MovieVideo;
import com.g0ku.movie.tmdb_movie.pojo.Video;


import javax.inject.Inject;

public class VideoAdapter extends RecyclerView.Adapter {


    private MovieVideo mList;

    @Inject
    public VideoAdapter() {
        this.mList = new MovieVideo();
    }


    public void setMovieVideo(MovieVideo movieVideo){
        if(movieVideo == null) return;

        this.mList = movieVideo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoViewHolder(LayoutVideoRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {


        VideoViewHolder holder = (VideoViewHolder) viewHolder;

        holder.update(mList.getVideos().get(position));

    }

    @Override
    public int getItemCount() {
        return MovieVideo.isEmpty(mList)? 0 : mList.getVideos().size();
    }




    private static class VideoViewHolder extends RecyclerView.ViewHolder{

        private LayoutVideoRowBinding mBinding;

        private VideoViewHolder(@NonNull LayoutVideoRowBinding itemView) {
            super(itemView.getRoot());
            this.mBinding = itemView;
        }


        private void update(Video video){

            mBinding.setVideo(video);

        }
    }
}
