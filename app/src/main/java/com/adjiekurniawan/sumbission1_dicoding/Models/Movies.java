package com.adjiekurniawan.sumbission1_dicoding.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {

    private String poster_name;
    private String poster_description;
    private String poster_rating;
    private int poster_cover;
    private String poster_duration;
    private String poster_category;
    private String poster_release_date;
    private String poster_release_date_long;
    private String poster_director;

    public String getPoster_name() {
        return poster_name;
    }

    public void setPoster_name(String poster_name) {
        this.poster_name = poster_name;
    }

    public String getPoster_description() {
        return poster_description;
    }

    public void setPoster_description(String poster_description) {
        this.poster_description = poster_description;
    }

    public String getPoster_rating() {
        return poster_rating;
    }

    public void setPoster_rating(String poster_rating) {
        this.poster_rating = poster_rating;
    }

    public int getPoster_cover() {
        return poster_cover;
    }

    public void setPoster_cover(int poster_cover) {
        this.poster_cover = poster_cover;
    }

    public String getPoster_duration() {
        return poster_duration;
    }

    public void setPoster_duration(String poster_duration) {
        this.poster_duration = poster_duration;
    }

    public String getPoster_category() {
        return poster_category;
    }

    public void setPoster_category(String poster_category) {
        this.poster_category = poster_category;
    }

    public String getPoster_release_date() {
        return poster_release_date;
    }

    public void setPoster_release_date(String poster_release_date) {
        this.poster_release_date = poster_release_date;
    }

    public Movies() {
    }

    public String getPoster_release_date_long() {
        return poster_release_date_long;
    }

    public void setPoster_release_date_long(String poster_release_date_long) {
        this.poster_release_date_long = poster_release_date_long;
    }

    public String getPoster_director() {
        return poster_director;
    }

    public void setPoster_director(String poster_director) {
        this.poster_director = poster_director;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster_name);
        dest.writeString(this.poster_description);
        dest.writeString(this.poster_rating);
        dest.writeInt(this.poster_cover);
        dest.writeString(this.poster_duration);
        dest.writeString(this.poster_category);
        dest.writeString(this.poster_release_date);
        dest.writeString(this.poster_release_date_long);
        dest.writeString(this.poster_director);
    }

    private Movies(Parcel in) {
        this.poster_name = in.readString();
        this.poster_description = in.readString();
        this.poster_rating = in.readString();
        this.poster_cover = in.readInt();
        this.poster_duration = in.readString();
        this.poster_category = in.readString();
        this.poster_release_date = in.readString();
        this.poster_release_date_long = in.readString();
        this.poster_director = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
