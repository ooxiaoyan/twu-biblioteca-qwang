package com.twu.biblioteca.entity;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class Book {

    private Integer id;
    private String name;
    private String author;
    private String yearOfPublication;
    private String status;

    public Book() {}

    public Book(Integer id, String name, String author, String yearOfPublication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
