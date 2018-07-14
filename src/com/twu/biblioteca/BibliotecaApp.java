package com.twu.biblioteca;

import com.twu.biblioteca.controller.BookController;

public class BibliotecaApp {

    public static void main(String[] args) {

        BookController bookController = new BookController();
        bookController.init();
    }
}
