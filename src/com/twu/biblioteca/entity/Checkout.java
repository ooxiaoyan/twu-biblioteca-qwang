package com.twu.biblioteca.entity;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class Checkout {

    private String id;
    private String name;
    private String type;
    private String time;

    public Checkout() {
    }

    public Checkout(String id, String name, String type, String time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }
}
