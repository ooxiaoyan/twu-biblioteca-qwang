package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.BookDataProvider;
import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Checkout;

import java.util.List;
import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookController {

    BookDataProvider bookDataProvider = new BookDataProvider();

    public void checkoutBookMenu(List<Checkout> checkoutList) {
        System.out.print("\nPlease enter the book id which you want to checkout: ");
        Scanner input = new Scanner(System.in);
        String bookId = input.next();

        Book book = checkoutBook(bookId);
        if (book != null) {
            Checkout checkoutObject = new Checkout(book.getId(), book.getName(), book.getClass().getSimpleName(), MainController.getTime());
            checkoutList.add(checkoutObject);
        }
    }

    public Book checkoutBook(String bookId) {
        Book book = bookDataProvider.getBook(bookId);
        if (book != null && book.getStatus().equals("1")) {
            int index = bookDataProvider.getBooks().indexOf(book);
            bookDataProvider.getBooks().get(index).setStatus("0");
            successfulCheckout();
            return book;
        } else {
            unsuccessfulCheckout();
            return null;
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
