package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class UserControllerTest {

    private UserController userController;

    @Before
    public void setup() {
        userController = new UserController();
    }

    @Test
    public void successful_login_when_the_number_and_password_are_correct() {
        String number = "bpl-0001";
        String password = "0001";
        boolean result = userController.login(number, password);
        assertTrue(result);
    }
}
