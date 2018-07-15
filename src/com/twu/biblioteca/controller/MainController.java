package com.twu.biblioteca.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MainController {

    BookController bookController = new BookController();
    MovieController movieController = new MovieController();
    UserController userController = new UserController();

    public void welcomeMessage() {
        System.out.print("----------Welcome to Biblioteca!----------\n");
    }

    public void mainMenu() {
        System.out.print("\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. List Movies\n" +
                "5. Checkout Movie\n" +
                "6. Return Movie\n" +
                "7. User Information\n" +
                "0. Quit\n" +
                "------------------------------------------\n" +
                "Please enter your choice: ");
    }

    public void init() {
        welcomeMessage();
        mainMenuPanel();
    }

    public void mainMenuPanel() {
        mainMenu();
        mainMenuOption();
    }

    public void mainMenuOption() {
        Scanner input = new Scanner(System.in);
        int num;
        try {
            num = input.nextInt();
        } catch (InputMismatchException e) {
            num = -1;
        }

        if (num == 2 || num == 3 || num == 5 || num == 7) {
            if (!userController.isLogin()) {
                boolean login = userController.loginMenu();
                if (!login) {
                    userController.unsuccessfulLogin();
                    mainMenuPanel();
                } else {
                    userController.successfulLogin();
                }
            }
        }

        if (num == 1) {
            bookController.bookDataProvider.printBookList();
            mainMenuPanel();
        } else if (num == 2) {
            bookController.checkoutBookMenu();
            mainMenuPanel();
        } else if (num == 3) {
            bookController.returnBookMenu();
            mainMenuPanel();
        } else if (num == 4) {
            movieController.movieDataProvider.printMovieList();
            mainMenuPanel();
        }else if (num == 7) {
            userController.printUserInfo();
            mainMenuPanel();
        } else if (num == 0) {
            quit();
        } else {
            invalidOptionMessage();
            mainMenuOption();
        }
    }

    public void quit() {
        System.exit(0);
    }

    public void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }
}
