package com.app.iqbaladinur.mymovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.iqbaladinur.mymovies.data.ParceableMovies;
import com.bumptech.glide.Glide;

public class DetailAnimuActivity extends AppCompatActivity {
    TextView title, category, score, date, synopsys;
    ImageView cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animu);
        //wiring view
        title   = (TextView) findViewById(R.id.title);
        category= (TextView) findViewById(R.id.category);
        date    = (TextView) findViewById(R.id.date);
        synopsys= (TextView) findViewById(R.id.synopsys);
        cover   = (ImageView) findViewById(R.id.cover);
        score   = (TextView) findViewById(R.id.score);

        //get data from previous activity
        Bundle pack = getIntent().getExtras();
        ParceableMovies data = pack.getParcelable("data");

        Glide.with(this)
                .load(data.getCover())
                .into(cover);

        title.setText(data.getTitle());
        category.setText(String.format("Category  : %s",data.getCategory()));
        date.setText(String.format("Aired on %s", data.getDate_aired()));
        synopsys.setText(data.getSynopsys());
        score.setText(String.format("Score : %s", data.getScore()));

    }
}
