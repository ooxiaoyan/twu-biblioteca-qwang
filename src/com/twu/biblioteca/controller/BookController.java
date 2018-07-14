package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.BookDataProvider;
import com.twu.biblioteca.entity.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookController {

    BookDataProvider bookDataProvider = new BookDataProvider();

    public void welcomeMessage() {
        System.out.print("----------Welcome to Biblioteca!----------\n\n");
    }

    public void mainMenu() {
        System.out.print("\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "0. Quit\n" +
                "------------------------------------------\n" +
                "Please enter your choice: ");
    }

    public void init() {
        welcomeMessage();
        mainMenuPanel();
    }

    public void mainMenuPanel() {
        mainMenu();
        mainMenuOption();
    }

    public void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }

    public void quit() {
        System.exit(0);
    }

    public void mainMenuOption() {
        Scanner input = new Scanner(System.in);
        int num;
        try {
            num = input.nextInt();
        } catch (InputMismatchException e) {
            num = -1;
        }

        if (num == 1) {
            bookDataProvider.printBookList();
            mainMenuPanel();
        } else if (num == 2) {
            checkoutBookMenu();
            mainMenuPanel();
        } else if (num == 3) {
            returnBookMenu();
            mainMenuPanel();
        } else if (num == 0) {
            quit();
        } else {
            invalidOptionMessage();
            mainMenuOption();
        }
    }

    public void checkoutBookMenu() {
        System.out.print("\nPlease enter the book id which you want to checkout: ");
        Scanner input = new Scanner(System.in);
        String bookId = input.next();
        checkoutBook(bookId);
    }

    public void checkoutBook(String bookId) {
        Book book = bookDataProvider.getBook(bookId);
        if (book != null && book.getStatus().equals("1")) {
            int index = bookDataProvider.getBooks().indexOf(book);
            bookDataProvider.getBooks().get(index).setStatus("0");
            successfulCheckout();
        } else {
            unsuccessfulCheckout();
        }
    }

    public void successfulCheckout() {
        System.out.println("\nThank you! Enjoy the book.");
    }

    public void unsuccessfulCheckout() {
        System.out.println("\nThat book is not available.");
    }

    public void returnBookMenu() {
        System.out.print("\nPlease enter the book id which you want to return: ");
        Scanner input = new Scanner(System.in);
        String bookId = input.next();
        returnBook(bookId);
    }

    public void returnBook(String bookId) {
        Book book = bookDataProvider.getBook(bookId);
        if (book != null && book.getStatus().equals("0")) {
            int index = bookDataProvider.getBooks().indexOf(book);
            bookDataProvider.getBooks().get(index).setStatus("1");
            successfulReturn();
        } else {
            unsuccessfulReturn();
        }
    }

    public void successfulReturn() {
        System.out.println("\nThank you for returning the book.");
    }

    public void unsuccessfulReturn() {
        System.out.println("\nThat is not a valid book to return.");
    }
}
