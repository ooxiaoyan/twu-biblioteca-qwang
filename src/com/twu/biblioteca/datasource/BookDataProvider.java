package com.twu.biblioteca.datasource;

import com.twu.biblioteca.entity.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookDataProvider {

    private List<Book> books = Arrays.asList(
            new Book("1", "Head First Java", "Kathy Sierra,BertBates", "2005"),
            new Book("2", "Pride and Prejudice", "Jane Austen", "1983"),
            new Book("3", "The Little Prince", "Antoine de Saint-Exupery", "1998"),
            new Book("4", "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "2001"),
            new Book("5", "Les Miserables", "Victor Hugo", "1862")
    );

    public List<Book> getBooks() {
        return books;
    }


    public void printBookList() {
        System.out.print("----------Here is the Book List----------\n");
        System.out.printf("%-10s", "Id");
        System.out.printf("%-60s", "Name");
        System.out.printf("%-40s", "Author");
        System.out.printf("%-5s\n", "YearOfPublication");

        for (Book book : getBooks()) {
            System.out.printf("%-10s", book.getId());
            System.out.printf("%-60s", book.getName());
            System.out.printf("%-40s", book.getAuthor());
            System.out.printf("%-5s\n", book.getYearOfPublication());
        }
    }
}
