package com.adjiekurniawan.sumbission1_dicoding.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adjiekurniawan.sumbission1_dicoding.Models.Movies;
import com.adjiekurniawan.sumbission1_dicoding.R;

import java.util.ArrayList;

public class MoviesAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movies> movies;


    public void setMovies(ArrayList<Movies> movies){
        this.movies = movies;
    }

    public MoviesAdapter(Context context){
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Movies movies = (Movies) getItem(position);
        viewHolder.bind(movies);
        return convertView;
    }

    private class ViewHolder{
        private ImageView poster_image;
        private TextView poster_title,
                poster_duration,
                poster_category,
                poster_description;
        private RatingBar poster_rating;

        ViewHolder(View view) {
            poster_image = view.findViewById(R.id.poster_image);
            poster_title = view.findViewById(R.id.poster_title);
            poster_duration = view.findViewById(R.id.poster_duration);
            poster_category = view.findViewById(R.id.poster_categoty);
            poster_description = view.findViewById(R.id.poster_description);
            poster_rating = view.findViewById(R.id.rating);
        }

        @SuppressLint("SetTextI18n")
        void bind(Movies movies) {
            poster_image.setImageResource(movies.getPoster_cover());
            poster_title.setText(movies.getPoster_name() + " " + movies.getPoster_release_date());
            poster_duration.setText(movies.getPoster_duration());
            poster_category.setText(movies.getPoster_category());
            poster_description.setText(movies.getPoster_description());
            poster_rating.setRating(Float.parseFloat(movies.getPoster_rating()));
        }

    }
}
