package com.twu.biblioteca.datasource;

import com.twu.biblioteca.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class UserDataProvider {

    private List<User> users = Arrays.asList(
            new User("bpl-0001", "0001", "Kathy Sierra,BertBates", "2005", "1"),
            new User("bpl-0002", "0002", "Jane Austen", "1983", "1"),
            new User("bpl-0003", "0003", "Antoine de Saint-Exupery", "1998", "1"),
            new User("bpl-0004", "0004", "J. K. Rowling", "2001", "1"),
            new User("bpl-0005", "0005", "Victor Hugo", "1862", "1")
    );

    public User getUser(String userNumber, String password) {
        for (User user : users) {
            if (user.getNumber().equals(userNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
