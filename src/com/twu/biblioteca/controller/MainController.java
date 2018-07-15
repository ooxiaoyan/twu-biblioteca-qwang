package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Checkout;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 筱湮 on 2018/7/15 0015.
 */
public class MainController {

    private BookController bookController = new BookController();
    private MovieController movieController = new MovieController();
    private UserController userController = new UserController();
    private List<Checkout> checkoutList = new ArrayList<Checkout>();

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
                "8. Checkout Information\n" +
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

        if (num == 2 || num == 3 || num == 5 || num == 7 || num == 8) {
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
            bookController.checkoutBookMenu(checkoutList);
            mainMenuPanel();
        } else if (num == 3) {
            bookController.returnBookMenu(checkoutList);
            mainMenuPanel();
        } else if (num == 4) {
            movieController.movieDataProvider.printMovieList();
            mainMenuPanel();
        } else if (num == 5) {
            movieController.checkoutMovieMenu(checkoutList);
            mainMenuPanel();
        } else if (num == 6) {
            movieController.returnMovieMenu(checkoutList);
            mainMenuPanel();
        } else if (num == 7) {
            userController.printUserInfo();
            mainMenuPanel();
        } else if (num == 8) {
            printCheckoutInfo();
            mainMenuPanel();
        } else if (num == 0) {
            quit();
        } else {
            invalidOptionMessage();
            mainMenuOption();
        }
    }

    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public void printCheckoutInfo() {
        if (checkoutList.size() == 0) {
            System.out.println("\n No checkout Book or Movie Data!\n");
        } else {
            System.out.print("\n---------- Checkout Information ----------\n");

            for (Checkout checkout : checkoutList) {
                System.out.printf("%-10s", "Id");
                System.out.printf("%-50s", "Name");
                System.out.printf("%-20s", "Type");
                System.out.printf("%-20s\n", "Time");

                System.out.printf("%-10s", checkout.getId());
                System.out.printf("%-50s", checkout.getName());
                System.out.printf("%-20s", checkout.getType());
                System.out.printf("%-20s\n", checkout.getTime());

                System.out.print("-----------------------------------------\n");
            }
        }
    }

    public void quit() {
        System.exit(0);
    }

    public void invalidOptionMessage() {
        System.out.print("Select a valid option! Please enter again your choice: ");
    }

    public BookController getBookController() {
        return bookController;
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public List<Checkout> getCheckoutList() {
        return checkoutList;
    }
}
