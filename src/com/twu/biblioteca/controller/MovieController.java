package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.MovieDataProvider;
import com.twu.biblioteca.entity.Movie;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieController {

    MovieDataProvider movieDataProvider = new MovieDataProvider();

    public void checkoutMovie(String movieId) {
        Movie movie = movieDataProvider.getMovie(movieId);
        if (movie != null && movie.getStatus().equals("1")) {
            int index = movieDataProvider.getMovies().indexOf(movie);
            movieDataProvider.getMovies().get(index).setStatus("0");
            successfulCheckout();
        } else {
            unsuccessfulCheckout();
        }
    }

    public void successfulCheckout() {
        System.out.println("\nThank you! Enjoy the movie.");
    }

    public void unsuccessfulCheckout() {
        System.out.println("\nThat movie is not available.");
    }
}
