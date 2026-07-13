package com.hirehub.ui;

import com.hirehub.model.User;
import com.hirehub.service.UserService;

import java.util.Scanner;

public class LoginUI {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();

    public void start() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("          HIREHUB LOGIN");
            System.out.println("=================================");
            System.out.println("1. Login");
            System.out.println("2. Exit");

            System.out.print("Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    login();
                    break;

                case 2:
                    System.out.println("Thank You.");
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

    }

    private void login() {

        System.out.print("Email : ");
        String email = scanner.nextLine();

        System.out.print("Password : ");
        String password = scanner.nextLine();

        User user = userService.loginUser(email, password);

        if (user == null) {

            System.out.println("\nInvalid Email or Password.");
            return;

        }

        System.out.println("\nWelcome " + user.getFullName());

        switch (user.getRole()) {

            case "ADMIN":
                new ConsoleUI().start();
                break;

            case "STUDENT":
                new StudentUI().start();
                break;

            case "COMPANY":
                new CompanyUI().start();
                break;

            case "PLACEMENT_OFFICER":
                new ConsoleUI().start();
                break;

            default:
                System.out.println("Unknown Role.");
        }

    }

}