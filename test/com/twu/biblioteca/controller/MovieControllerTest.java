package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.MovieDataProvider;
import com.twu.biblioteca.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MovieControllerTest {

    private MovieController movieController;
    private MainController mainController;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        movieController = new MovieController();
        mainController = new MainController();
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

    @Test
    public void print_main_menu_should_have_the_list_movies() {
        mainController.mainMenu();
        assertThat(systemOut(), containsString("List Movies"));
    }

    @Test
    public void check_out_movie_should_not_appear_in_the_list_of_all_library_movies() {
        MovieDataProvider movieDataProvider = new MovieDataProvider();
        List<Movie> movies = checkoutMovies();
        movieDataProvider.setMovies(movies);

        movieController.checkoutMovie("mov002");
        assertThat(movieDataProvider.getMovies(), is(movieController.movieDataProvider.getMovies()));
    }

    @Test
    public void should_print_successful_message_after_successful_checkout_movie() {
        movieController.checkoutMovie("mov002");
        assertThat(systemOut(), containsString("Thank you! Enjoy the movie."));
    }

    @Test
    public void should_print_unsuccessful_message_after_unsuccessful_checkout_movie() {
        movieController.checkoutMovie("mov010");
        assertThat(systemOut(), containsString("That movie is not available."));
    }
}
