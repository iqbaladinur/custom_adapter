package com.app.iqbaladinur.mymovies.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.iqbaladinur.mymovies.DetailAnimuActivity;
import com.app.iqbaladinur.mymovies.MainActivity;
import com.app.iqbaladinur.mymovies.R;
import com.app.iqbaladinur.mymovies.data.Movies;
import com.app.iqbaladinur.mymovies.data.ParceableMovies;
import com.app.iqbaladinur.mymovies.listener.CustomOnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by sanja on 26/09/2017.
 */

public class ListMoviesAdapter extends RecyclerView.Adapter<ListMoviesAdapter.CategoryViewHolder> {

    private Context context;
    private Intent detailActivity;
    private ArrayList<Movies> listMovies;

    public ListMoviesAdapter(Context context){
        this.context = context;
    }

    public  ArrayList<Movies> getListMovies(){
        return  listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies){
        this.listMovies = listMovies;
    }



    @Override
    public ListMoviesAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_row_layout, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(ListMoviesAdapter.CategoryViewHolder holder, int position) {
        holder.title.setText(getListMovies().get(position).getTitle());
        holder.category.setText(getListMovies().get(position).getCategory());
        holder.score.setText(getListMovies().get(position).getScore());

        Glide.with(context)
                .load(getListMovies().get(position).getCover())
                .override(72, 72)
                .crossFade()
                .into(holder.cover);
        /*implement custom listener click*/
        holder.list_parent.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemCallBack() {
            @Override
            public void onItemClicked(View view, int position) {
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

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView category;
        TextView score;
        ImageView cover;
        RelativeLayout list_parent;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            title       = (TextView) itemView.findViewById(R.id.title);
            category    = (TextView) itemView.findViewById(R.id.category);
            score       = (TextView) itemView.findViewById(R.id.score);
            cover       = (ImageView) itemView.findViewById(R.id.img_cover);
            list_parent = (RelativeLayout) itemView.findViewById(R.id.list_parent);
        }
    }
}
