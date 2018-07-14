package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookControllerTest {

    private BookController bookController;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        bookController = new BookController();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_print_welcome_message_when_customer_start_the_application() {
        bookController.welcomeMessage();
        assertThat(systemOut(), containsString("----------Welcome to Biblioteca!----------\n\n"));
    }

    @Test
    public void should_print_main_menu_after_welcome_message() {
        bookController.init();
        assertThat(systemOut(), containsString(
                "----------Welcome to Biblioteca!----------\n\n" +
                        "1. List Books\n" +
                        "------------------------------------------\n" +
                        "Please enter your choice: "));
    }

    @Test
    public void should_be_notified_when_customer_choose_an_invalid_option() {
        bookController.invalidOptionMessage();
        assertThat(systemOut(), containsString("Select a valid option! Please enter again your choice: "));
    }
}
