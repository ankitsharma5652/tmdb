package com.g0ku.movie.tmdb_movie.adapter;

import com.g0ku.movie.tmdb_movie.R;
import com.g0ku.movie.tmdb_movie.pojo.HomeItem;
import com.g0ku.movie.tmdb_movie.viewholder.BaseViewHolder;
import com.g0ku.movie.tmdb_movie.viewholder.HomeItemViewHolder;
import com.g0ku.movie.tmdb_movie.viewmodel.BannerItemViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class HomeListAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<HomeItem> itemList;


    @Inject
    public HomeListAdapter() {
        this.itemList = new ArrayList<>();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return HomeAdapterFactory.create(parent,viewType);
    }


    @Override
    public void onViewAttachedToWindow(@NonNull BaseViewHolder holder) {
        holder.onAttach();
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int position) {
        viewHolder.onBind(itemList.get(position));
    }


    @Override
    public void onViewDetachedFromWindow(@NonNull BaseViewHolder holder) {
        holder.onDetach();

    }

    @Override
    public void onViewRecycled(@NonNull BaseViewHolder holder) {
        holder.onRecycle();
    }


    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        return itemList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return itemList.size();

    }


    public void addAll(List<HomeItem> list) {

        if(list == null || list.isEmpty()) return;

        int size = itemList.size();

        this.itemList.addAll(list);

        notifyItemRangeInserted(size,list.size());

    }
}
