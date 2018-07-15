package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.UserDataProvider;
import com.twu.biblioteca.entity.User;

import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class UserController {

    UserDataProvider userDataProvider = new UserDataProvider();
    User user;

    public boolean login(String number, String password) {
        User u = userDataProvider.getUser(number, password);
        if (u != null) {
            user = u;
            return true;
        }
        return false;
    }

    public boolean loginMenu() {
        System.out.print("\nPlease enter your library number: ");
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        System.out.print("\nPlease enter your password: ");
        String password = input.nextLine();
        return login(number, password);
    }

    public boolean isLogin() {
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    public void successfulLogin() {
        System.out.println("\nSuccessful Login!");
    }

    public void unsuccessfulLogin() {
        System.out.println("\nUnsuccessful Login! Your number or password is wrong!!");
    }

    public void printUserInfo() {
        System.out.print("\n---------- User Information ----------\n");
        System.out.printf("%-40s", "Name");
        System.out.printf("%-50s", "Email");
        System.out.printf("%-20s\n", "Phone");

        System.out.printf("%-40s", user.getName());
        System.out.printf("%-50s", user.getEmail());
        System.out.printf("%-20s\n", user.getPhone());

        System.out.print("-----------------------------------------\n");

    }
}
