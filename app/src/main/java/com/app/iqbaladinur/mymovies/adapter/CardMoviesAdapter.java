package com.app.iqbaladinur.mymovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class CardMoviesAdapter extends RecyclerView.Adapter<CardMoviesAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Movies> listMovies;
    private Intent detailActivity;

    public CardMoviesAdapter(Context context){
        this.context = context;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_card, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Movies mov = getListMovies().get(position);

        Glide.with(context)
                .load(mov.getCover())
                .override(100, 350)
                .into(holder.imgCover);

        holder.title.setText(mov.getTitle());
        holder.category.setText(mov.getCategory());
        holder.score.setText(mov.getScore());
        holder.btn.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemCallBack(){

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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView title, category, score;
        Button btn;
        public CardViewHolder(View itemView) {
            super(itemView);
            imgCover    = (ImageView) itemView.findViewById(R.id.cover_card);
            title       = (TextView) itemView.findViewById(R.id.title_card);
            category    = (TextView) itemView.findViewById(R.id.category);
            score       = (TextView) itemView.findViewById(R.id.score);
            btn         = (Button) itemView.findViewById(R.id.btn_view);
        }
    }
}
