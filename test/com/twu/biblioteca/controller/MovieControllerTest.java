package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieControllerTest {

    private MovieController movieController;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        movieController = new MovieController();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    private List<Movie> noCheckoutMovies() {
        return Arrays.asList(
                new Movie("mov001", "The Shawshank Redemption", "1994", "Frank Darabont", 9, "1"),
                new Movie("mov002", "Léon", "1994", "Luc Besson", 9, "1"),
                new Movie("mov003", "Inception", "2010", "Christopher Nolan", 9, "1"),
                new Movie("mov004", "The Godfather", "1972", "Francis Ford Coppola", 9, "1")
        );
    }

    private List<Movie> checkoutMovies() {
        return Arrays.asList(
                new Movie("mov001", "The Shawshank Redemption", "1994", "Frank Darabont", 9, "1"),
                new Movie("mov002", "Léon", "1994", "Luc Besson", 9, "0"),
                new Movie("mov003", "Inception", "2010", "Christopher Nolan", 9, "1"),
                new Movie("mov004", "The Godfather", "1972", "Francis Ford Coppola", 9, "1")
        );
    }

    @Test
    public void should_print_a_list_of_available_movies() {
        movieController.movieDataProvider.printMovieList();
        String result =
                "Id        Name                                              Year      Director                                          Rating\n" +
                "mov001    The Shawshank Redemption                          1994      Frank Darabont                                    9    \n" +
                "mov002    Léon                                              1994      Luc Besson                                        9    \n" +
                "mov003    Inception                                         2010      Christopher Nolan                                 9    \n" +
                "mov004    The Godfather                                     1972      Francis Ford Coppola                              9 ";
        assertThat(systemOut(), containsString(result));
    }
}
