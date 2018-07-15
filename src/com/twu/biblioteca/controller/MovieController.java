package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.MovieDataProvider;
import com.twu.biblioteca.entity.Movie;

import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieController {

    MovieDataProvider movieDataProvider = new MovieDataProvider();

    public Movie checkoutMovieMenu() {
        System.out.print("\nPlease enter the movie id which you want to checkout: ");
        Scanner input = new Scanner(System.in);
        String movieId = input.next();
        return checkoutMovie(movieId);
    }

    public Movie checkoutMovie(String movieId) {
        Movie movie = movieDataProvider.getMovie(movieId);
        if (movie != null && movie.getStatus().equals("1")) {
            int index = movieDataProvider.getMovies().indexOf(movie);
            movieDataProvider.getMovies().get(index).setStatus("0");
            successfulCheckout();
            return movie;
        } else {
            unsuccessfulCheckout();
            return null;
        }
    }

    public void successfulCheckout() {
        System.out.println("\nThank you! Enjoy the movie.");
    }

    public void unsuccessfulCheckout() {
        System.out.println("\nThat movie is not available.");
    }
}
