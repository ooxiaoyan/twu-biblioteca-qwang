package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.UserDataProvider;
import com.twu.biblioteca.entity.User;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class UserController {

    UserDataProvider userDataProvider = new UserDataProvider();

    public boolean login(String number, String password) {
        User user = userDataProvider.getUser(number, password);
        if (user != null) {
            user.setLoginStatus(true);
            return true;
        }
        return false;
    }
}
