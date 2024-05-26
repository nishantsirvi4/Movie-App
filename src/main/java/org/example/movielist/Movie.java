package org.example.movielist;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Movie {

    private int id;
    private String title;
    @SerializedName("director")
    private String directorName;
    private String language;

    @SerializedName("rating_type")
    private String ratingType;
    @SerializedName("release_year")
    private int releaseYear;
    private double rating;
    private String[] genres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", directorName='" + directorName + '\'' +
                ", language='" + language + '\'' +
                ", ratingType='" + ratingType + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}

