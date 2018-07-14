package com.twu.biblioteca.datasource;

import com.twu.biblioteca.entity.Movie;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieDataProvider {

    private List<Movie> movies = Arrays.asList(
            new Movie("mov001", "The Shawshank Redemption", "1994", "Frank Darabont", 9, "1"),
            new Movie("mov002", "Léon", "1994", "Luc Besson", 9, "1"),
            new Movie("mov003", "Inception", "2010", "Christopher Nolan", 9, "1"),
            new Movie("mov004", "The Godfather", "1972", "Francis Ford Coppola", 9, "1")
        );

    public List<Movie> getMovies() {
        return movies;
    }

    public void printMovieList() {
        System.out.print("----------Here is the Movie List----------\n");
        System.out.printf("%-10s", "Id");
        System.out.printf("%-50s", "Name");
        System.out.printf("%-10s", "Year");
        System.out.printf("%-50s", "Director");
        System.out.printf("%-5s\n", "Rating");

        for (Movie movie : getMovies()) {
            if ("0".equals(movie.getStatus())) {
                continue;
            }
            System.out.printf("%-10s", movie.getId());
            System.out.printf("%-50s", movie.getName());
            System.out.printf("%-10s", movie.getYear());
            System.out.printf("%-50s", movie.getDirector());
            System.out.printf("%-5d\n", movie.getRating());
        }
        System.out.print("-----------------------------------------\n");
    }
}
