package com.twu.biblioteca.datasource;

import com.twu.biblioteca.entity.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookDataProvider {

    private List<Book> books = Arrays.asList(
            new Book("twu001", "Head First Java", "Kathy Sierra,BertBates", "2005", "1"),
            new Book("twu002", "Pride and Prejudice", "Jane Austen", "1983", "1"),
            new Book("twu003", "The Little Prince", "Antoine de Saint-Exupery", "1998", "1"),
            new Book("twu004", "Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", "2001", "1"),
            new Book("twu005", "Les Miserables", "Victor Hugo", "1862", "1")
    );

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List books) {
        this.books = books;
    }

    public void printBookList() {
        System.out.print("----------Here is the Book List----------\n");
        System.out.printf("%-10s", "Id");
        System.out.printf("%-60s", "Name");
        System.out.printf("%-40s", "Author");
        System.out.printf("%-5s\n", "YearOfPublication");

        for (Book book : getBooks()) {
            if ("0".equals(book.getStatus())) {
                continue;
            }
            System.out.printf("%-10s", book.getId());
            System.out.printf("%-60s", book.getName());
            System.out.printf("%-40s", book.getAuthor());
            System.out.printf("%-5s\n", book.getYearOfPublication());
        }
        System.out.print("-----------------------------------------\n");
    }

    public Book getBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
