package com.g0ku.movie.tmdb_movie.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.PeopleImage;
import com.g0ku.movie.tmdb_movie.pojo.PeopleImg;
import com.g0ku.movie.tmdb_movie.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class PeopleImagePagerAdapter extends RecyclerView.Adapter {

   private List<PeopleImg> mList;

    public PeopleImagePagerAdapter() {
        this.mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PeopleImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_cast_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        ((PeopleImageViewHolder)viewHolder).update(mList.get(i));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void loadMore(List<PeopleImg> images){
        if(images == null || images.isEmpty()) return;

        int size = mList.size();

        mList.addAll(images);
        notifyItemRangeInserted(size,images.size());
    }




    public void addAll(List<PeopleImg> images){
        mList.clear();

        if(images == null || images.isEmpty()) return;

        mList.addAll(images);
        notifyItemRangeInserted(0,images.size());
    }






    public static class PeopleImageViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public PeopleImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cast_img);
            itemView.findViewById(R.id.real_name).setVisibility(View.GONE);
            itemView.findViewById(R.id.movie_name).setVisibility(View.GONE);
        }

        public void update(PeopleImg img){

            ImageUtil.setImage(imageView,img.getFilePath());

//            imageView.getLayoutParams().width = img.getWidth();
//            imageView.getLayoutParams().height = img.getHeight();

        }
    }
}
