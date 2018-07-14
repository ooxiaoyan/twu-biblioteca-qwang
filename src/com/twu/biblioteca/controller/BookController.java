package com.twu.biblioteca.controller;

import com.twu.biblioteca.datasource.BookDataProvider;

import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/14 0014.
 */
public class BookController {

    BookDataProvider bookDataProvider = new BookDataProvider();

    public void welcomeMessage() {
        System.out.print("----------Welcome to Biblioteca!----------\n\n");
    }

    public void mainMenu() {
        System.out.print(
                "1. List Books\n" +
                "2. Quit\n" +
                "------------------------------------------\n" +
                "Please enter your choice: ");
    }

    public void init() {
        welcomeMessage();
        mainMenu();

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        mainMenuOption(num);
    }

    public void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }

    public void quit() {
        System.exit(0);
    }

    public void mainMenuOption(int n) {
        if (n == 1) {
            bookDataProvider.printBookList();
        } else if (n == 2) {
            quit();
        } else {
            invalidOptionMessage();
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            mainMenuOption(num);
        }
    }
}
