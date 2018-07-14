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
        assertThat(systemOut(),containsString("Welcome to Biblioteca!"));
    }

}
