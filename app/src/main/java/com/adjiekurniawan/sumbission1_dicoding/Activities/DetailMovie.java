package com.adjiekurniawan.sumbission1_dicoding.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.adjiekurniawan.sumbission1_dicoding.Models.Movies;
import com.adjiekurniawan.sumbission1_dicoding.R;
import java.util.Objects;

public class DetailMovie extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView poster_title;
    private TextView poster_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        initToolbar();
    }

    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.back_button);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setTitle(null);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initData();

    }

    @SuppressLint("SetTextI18n")
    private void initData(){

        ImageView poster_image = findViewById(R.id.poster_image);
        ImageView poster_cover = findViewById(R.id.poster_cover);
        poster_title = findViewById(R.id.poster_title);
        TextView poster_duration = findViewById(R.id.poster_duration);
        TextView poster_category = findViewById(R.id.poster_categoty);
        TextView poster_release_date = findViewById(R.id.poster_release_data);
        TextView poster_director = findViewById(R.id.poster_director);
        poster_description = findViewById(R.id.poster_description);
        RatingBar poster_rating = findViewById(R.id.rating);
        TextView poster_rating_text = findViewById(R.id.poster_rating_text);
        Button btn_poster_like = findViewById(R.id.btn_poster_like);

        Movies movies = getIntent().getParcelableExtra(EXTRA_MOVIE);

        poster_image.setImageResource(movies.getPoster_cover());
        poster_cover.setImageResource(movies.getPoster_cover());
        poster_title.setText(movies.getPoster_name());
        poster_duration.setText(movies.getPoster_duration());
        poster_category.setText(getString(R.string.txt_detail_category) + " " + movies.getPoster_category());
        poster_description.setText(movies.getPoster_description());
        poster_rating.setRating(Float.parseFloat(movies.getPoster_rating()));
        poster_rating_text.setText(movies.getPoster_rating());
        poster_release_date.setText(getString(R.string.txt_detail_release_date) + " " + movies.getPoster_release_date_long());
        poster_director.setText(getString(R.string.txt_detail_director) + " " + movies.getPoster_director());

        btn_poster_like.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = poster_title.getText().toString() + "\n" +
                    poster_description.getText().toString() + "\n" +
                    getString(R.string.txt_detail_shared);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, R.string.txt_detail_subject);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, getString(R.string.txt_detail_title)));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_poster_like) {
            Toast.makeText(this, getString(R.string.txt_detail_clicked) + poster_title.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
