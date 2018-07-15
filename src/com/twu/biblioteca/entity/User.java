package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class User {

    private String number;
    private String password;
    private String name;
    private String email;
    private String phone;

    private List checkoutList = new ArrayList();

    public User() {
    }

    public User(String number, String password, String name, String email, String phone) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("number", this.number);
        map.put("password", this.password);
        map.put("name", this.name);
        map.put("email", this.email);
        map.put("phone", this.phone);
        return map.toString();
    }
}
