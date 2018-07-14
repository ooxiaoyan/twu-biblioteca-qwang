package com.twu.biblioteca.controller;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookController {

    public static void welcomeMessage() {
        System.out.print("----------Welcome to Biblioteca!----------\n\n");
    }

    public static void mainMenu() {
        System.out.print(
                "1. List Books\n" +
                "------------------------------------------\n" +
                "Please enter your choice: ");
    }

    public static void init() {
        welcomeMessage();
        mainMenu();
    }

    public static void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }
}
