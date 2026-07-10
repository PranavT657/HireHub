package com.hirehub.ui;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n====================================");
            System.out.println("             HIREHUB");
            System.out.println("====================================");
            System.out.println("1. User Management");
            System.out.println("2. Student Management");
            System.out.println("3. Company Management");
            System.out.println("4. Job Management");
            System.out.println("5. Application Management");
            System.out.println("6. Exit");
            System.out.println("====================================");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    UserUI userUI = new UserUI();
                    userUI.start();
                    break;

                case 2:
                    StudentUI studentUI = new StudentUI();
                    studentUI.start();
                    break;

                case 3:
                       CompanyUI companyUI = new CompanyUI();
                       companyUI.start();
                    break;

                case 4:
    JobUI jobUI = new JobUI();
    jobUI.start();
    break;

                case 5:
                    System.out.println("\nApplication Module Coming Soon...");
                    break;

                case 6:
                    System.out.println("\nThank You For Using HireHub.");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid Choice.");
            }
        }
    }
}