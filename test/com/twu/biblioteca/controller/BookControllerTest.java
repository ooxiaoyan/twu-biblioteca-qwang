package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.BookDataProvider;
import com.twu.biblioteca.entity.Book;
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
    public void print_main_menu_should_have_the_list_books() {
        bookController.mainMenu();
        assertThat(systemOut(), containsString("1. List Books"));
    }

    @Test
    public void should_be_notified_when_customer_choose_an_invalid_option() {
        bookController.invalidOptionMessage();
        assertThat(systemOut(), containsString("Select a valid option! Please enter again your choice: "));
    }

    private List<Book> noCheckoutBooks() {
        return Arrays.asList(
                new Book("twu001", "Head First Java", "Kathy Sierra,BertBates", "2005", "1"),
                new Book("twu002", "Pride and Prejudice", "Jane Austen", "1983", "1"),
                new Book("twu003", "The Little Prince", "Antoine de Saint-Exupery", "1998", "1"),
                new Book("twu004", "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "2001", "1"),
                new Book("twu005", "Les Miserables", "Victor Hugo", "1862", "1")
        );
    }

    private List<Book> checkoutBooks() {
        return Arrays.asList(
                new Book("twu001", "Head First Java", "Kathy Sierra,BertBates", "2005", "0"),
                new Book("twu002", "Pride and Prejudice", "Jane Austen", "1983", "1"),
                new Book("twu003", "The Little Prince", "Antoine de Saint-Exupery", "1998", "1"),
                new Book("twu004", "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "2001", "1"),
                new Book("twu005", "Les Miserables", "Victor Hugo", "1862", "1")
        );
    }

    @Test
    public void check_out_book_should_not_appear_in_the_list_of_all_library_books() {
        BookDataProvider bookDataProvider = new BookDataProvider();
        List<Book> books = checkoutBooks();
        bookDataProvider.setBooks(books);

        bookController.checkoutBook("twu001");
        assertThat(bookDataProvider.getBooks(), is(bookController.bookDataProvider.getBooks()));
    }

    @Test
    public void should_print_successful_message_after_successful_checkout_book() {
        bookController.checkoutBook("twu002");
        assertThat(systemOut(), containsString("Thank you! Enjoy the book."));
    }

    @Test
    public void should_print_unsuccessful_message_after_unsuccessful_checkout_book() {
        bookController.checkoutBook("twu010");
        assertThat(systemOut(), containsString("That book is not available."));
    }

    @Test
    public void returned_book_should_appear_in_the_list_of_library_books() {
        List<Book> books = checkoutBooks();
        bookController.bookDataProvider.setBooks(books);
        bookController.returnBook("twu001");
        assertThat(bookController.bookDataProvider.getBooks(), is(noCheckoutBooks()));
    }

    @Test
    public void should_print_successful_message_after_successful_return_book() {
        bookController.bookDataProvider.setBooks(checkoutBooks());
        bookController.returnBook("twu001");
        assertThat(systemOut(), containsString("Thank you for returning the book."));
    }

    @Test
    public void should_print_unsuccessful_message_after_unsuccessful_return_book() {
        bookController.bookDataProvider.setBooks(checkoutBooks());
        bookController.returnBook("twu002");
        assertThat(systemOut(), containsString("That is not a valid book to return."));
    }
}
