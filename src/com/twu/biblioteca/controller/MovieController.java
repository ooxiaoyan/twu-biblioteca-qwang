package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.MovieDataProvider;
import com.twu.biblioteca.entity.Checkout;
import com.twu.biblioteca.entity.Movie;

import java.util.List;
import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieController {

    MovieDataProvider movieDataProvider = new MovieDataProvider();

    public void checkoutMovieMenu(List<Checkout> checkoutList) {
        System.out.print("\nPlease enter the movie id which you want to checkout: ");
        Scanner input = new Scanner(System.in);
        String movieId = input.next();

        Movie movie = checkoutMovie(movieId);
        if (movie != null) {
            Checkout checkoutObject = new Checkout(movie.getId(), movie.getName(), movie.getClass().getSimpleName(), MainController.getTime());
            checkoutList.add(checkoutObject);
        }
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
