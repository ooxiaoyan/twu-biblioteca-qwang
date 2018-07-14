package com.twu.biblioteca.entity;

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
}
