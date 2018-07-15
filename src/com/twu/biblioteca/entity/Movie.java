package com.twu.biblioteca.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class Movie {

    private String id;
    private String name;
    private String year;
    private String director;
    private int rating;
    private String status;

    public Movie() {
    }

    public Movie(String id, String name, String year, String director, int rating, String status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("year", this.year);
        map.put("director", this.director);
        map.put("rating", this.rating);
        map.put("status", this.status);
        return map.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (rating != movie.rating) return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        return director != null ? director.equals(movie.director) : movie.director == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }
}
