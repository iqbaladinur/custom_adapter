package com.app.iqbaladinur.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.app.iqbaladinur.mymovies.adapter.CardMoviesAdapter;
import com.app.iqbaladinur.mymovies.adapter.GridMoviesAdapter;
import com.app.iqbaladinur.mymovies.adapter.ListMoviesAdapter;
import com.app.iqbaladinur.mymovies.data.Movies;
import com.app.iqbaladinur.mymovies.data.MoviesData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Movies> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(MoviesData.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                setTitleBar("List Mode");
                showRecyclerList();
                break;
            case R.id.action_grid:
                setTitleBar("Grid Mode");
                showRecyclerGrid();
                break;
            case R.id.action_card_view:
                setTitleBar("Card Mode");
                showRecyclerCard();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMoviesAdapter listMoviesAdp = new ListMoviesAdapter(this);
        listMoviesAdp.setListMovies(list);
        rvCategory.setAdapter(listMoviesAdp);
    }
    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridMoviesAdapter gridMoviesAdp = new GridMoviesAdapter(this);
        gridMoviesAdp.setListMovies(list);
        rvCategory.setAdapter(gridMoviesAdp);
    }

    private void showRecyclerCard(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        CardMoviesAdapter cardMoviesAdapter = new CardMoviesAdapter(this);
        cardMoviesAdapter.setListMovies(list);
        rvCategory.setAdapter(cardMoviesAdapter);
    }

    private void setTitleBar(String titleBar){
        getSupportActionBar().setTitle(titleBar);
    }
}
