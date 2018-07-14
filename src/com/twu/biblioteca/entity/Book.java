package com.twu.biblioteca.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class Book {

    private String id;
    private String name;
    private String author;
    private String yearOfPublication;
    private String status; // 1 - customer can checkout the book; 0 - customer can not checkout the book

    public Book() {}

    public Book(String id, String name, String author, String yearOfPublication, String status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.status = status;
    }

    public String getId() {
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

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("name", this.name);
        map.put("author", this.author);
        map.put("yearOfPublication", this.yearOfPublication);
        map.put("status", this.status);
        return map.toString();
    }
}
