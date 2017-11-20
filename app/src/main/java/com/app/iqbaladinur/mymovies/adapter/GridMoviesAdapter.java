package com.app.iqbaladinur.mymovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.iqbaladinur.mymovies.DetailAnimuActivity;
import com.app.iqbaladinur.mymovies.R;
import com.app.iqbaladinur.mymovies.data.Movies;
import com.app.iqbaladinur.mymovies.data.ParceableMovies;
import com.app.iqbaladinur.mymovies.listener.CustomOnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by sanja on 26/09/2017.
 */

public class GridMoviesAdapter extends RecyclerView.Adapter<GridMoviesAdapter.GridViewHolder>{
    private Context context;
    private ArrayList<Movies> listMovies;
    private Intent detailActivity;

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    public GridMoviesAdapter(Context context){
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_grid, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListMovies().get(position).getCover())
                .override(350, 550)
                .into(holder.cover);

        holder.cover.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemCallBack() {
            @Override
            public void onItemClicked(View view, int position) {
                //here put data and kirim ke detail activity
                detailActivity = new Intent(context, DetailAnimuActivity.class);
                detailActivity.putExtra("data", new ParceableMovies(getListMovies().get(position)));
                context.startActivity(detailActivity);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }


    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        public GridViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover_grid);
        }
    }
}
