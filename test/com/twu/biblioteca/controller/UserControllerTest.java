package com.twu.biblioteca.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class UserControllerTest {

    private UserController userController;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        userController = new UserController();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void successful_login_when_the_number_and_password_are_correct() {
        String number = "bpl-0001";
        String password = "0001";
        boolean result = userController.login(number, password);
        assertTrue(result);
    }

    @Test
    public void should_print_user_information_when_user_logged_in() {
        String userInfo =
                "Name                                    Email                                             Phone               \n" +
                "Kathy Sierra                            Sierra@gmail.com                                  15348673587 ";

        userController.login("bpl-0001", "0001");
        userController.printUserInfo();

        assertThat(systemOut(), containsString(userInfo));
    }
}
