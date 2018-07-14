package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.BookDataProvider;
import com.twu.biblioteca.entity.Book;

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
        System.out.print(
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "0. Quit\n" +
                "------------------------------------------\n" +
                "Please enter your choice: ");

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        mainMenuOption(num);
    }

    public void init() {
        welcomeMessage();
        mainMenu();
    }

    public void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }

    public void quit() {
        System.exit(0);
    }

    public void mainMenuOption(int n) {
        if (n == 1) {
            bookDataProvider.printBookList();
        } else if (n == 2) {
            checkoutBookMenu();
        } else if (n == 0) {
            quit();
        } else {
            invalidOptionMessage();
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            mainMenuOption(num);
        }
    }

    public void checkoutBookMenu() {
        System.out.print("\nPlease enter the book id which you want to checkout: ");
        Scanner input = new Scanner(System.in);
        String bookId = input.next();
        checkoutBook(bookId);

        mainMenu();
    }

    public void checkoutBook(String bookId) {
        Book book = bookDataProvider.getBook(bookId);
        if (book != null) {
            int index = bookDataProvider.getBooks().indexOf(book);
            bookDataProvider.getBooks().get(index).setStatus("0");
            successfulCheckout();
        } else {
            unsuccessfulCheckout();
        }
    }

    public void successfulCheckout() {
        System.out.println("Thank you! Enjoy the book.");
    }

    public void unsuccessfulCheckout() {
        System.out.println("That book is not available.");
    }
}
