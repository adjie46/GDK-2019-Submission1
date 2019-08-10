package com.adjiekurniawan.sumbission1_dicoding.Activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adjiekurniawan.sumbission1_dicoding.Adapters.MoviesAdapter;
import com.adjiekurniawan.sumbission1_dicoding.Models.Movies;
import com.adjiekurniawan.sumbission1_dicoding.R;

import java.util.ArrayList;

public class MainMovie extends AppCompatActivity {

    private String[] dataMovie;
    private String[] dataDuration;
    private String[] dataCategory;
    private String[] dataDescription;
    private String[] datarating;
    private String[] datareleasedatelong;
    private String[] datadirector;
    private TypedArray dataCover;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesAdapter = new MoviesAdapter(this);

        ListView listView = findViewById(R.id.movie_list);
        listView.setAdapter(moviesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Movies movie = new Movies();
                movie.setPoster_cover(dataCover.getResourceId(i,-1));
                movie.setPoster_name(dataMovie[i]);
                movie.setPoster_category(dataCategory[i]);
                movie.setPoster_duration(dataDuration[i]);
                movie.setPoster_description(dataDescription[i]);
                movie.setPoster_rating(datarating[i]);
                movie.setPoster_release_date_long(datareleasedatelong[i]);
                movie.setPoster_director(datadirector[i]);
                Intent detailMovie = new Intent(MainMovie.this, DetailMovie.class);
                detailMovie.putExtra(DetailMovie.EXTRA_MOVIE, movie);
                startActivity(detailMovie);

            }
        });


        initToolbar();

    }

    private void initToolbar(){
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.putih));
        }
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        initItems();
    }

    private void initItems(){

        dataCover = getResources().obtainTypedArray(R.array.data_cover);
        dataMovie = getResources().getStringArray(R.array.data_movie);
        dataDuration = getResources().getStringArray(R.array.data_duration);
        dataCategory = getResources().getStringArray(R.array.data_category);
        dataDescription = getResources().getStringArray(R.array.data_description);
        datarating = getResources().getStringArray(R.array.data_rating);
        String[] datareleasedate = getResources().getStringArray(R.array.data_release_date_short);
        datareleasedatelong = getResources().getStringArray(R.array.data_release_date_long);
        datadirector = getResources().getStringArray(R.array.data_director);

        ArrayList<Movies> movies = new ArrayList<>();
        for(int i=0;i<dataMovie.length;i++){
            Movies movie = new Movies();
            movie.setPoster_cover(dataCover.getResourceId(i,-1));
            movie.setPoster_name(dataMovie[i]);
            movie.setPoster_category(dataCategory[i]);
            movie.setPoster_duration(dataDuration[i]);
            movie.setPoster_description(dataDescription[i]);
            movie.setPoster_rating(datarating[i]);
            movie.setPoster_release_date(datareleasedate[i]);
            movie.setPoster_release_date_long(datareleasedatelong[i]);
            movie.setPoster_director(datadirector[i]);
            movies.add(movie);
        }
        moviesAdapter.setMovies(movies);
    }



}
