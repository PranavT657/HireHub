package com.hirehub.ui;

import com.hirehub.model.User;
import com.hirehub.service.UserService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class UserUI {

    private Scanner scanner = new Scanner(System.in);
    private UserService userService = new UserService();

    public void start() {

        while (true) {

            System.out.println("\n========== USER MANAGEMENT ==========");
            System.out.println("1. Register User");
            System.out.println("2. View All Users");
            System.out.println("3. Search User");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    viewAllUsers();
                    break;

                case 3:
                    searchUser();
                    break;

                case 4:
                    updateUser();
                    break;

                case 5:
                    deleteUser();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    // ==========================
    // REGISTER USER
    // ==========================
    private void registerUser() {

        scanner.nextLine();

        User user = new User();

        System.out.println("\n========== REGISTER USER ==========");

        System.out.print("Full Name : ");
        user.setFullName(scanner.nextLine());

        System.out.print("Email : ");
        user.setEmail(scanner.nextLine());

        System.out.print("Password : ");
        user.setPassword(scanner.nextLine());

        System.out.print("Phone : ");
        user.setPhone(scanner.nextLine());

        System.out.print("Role (STUDENT/COMPANY/PLACEMENT_OFFICER/ADMIN): ");
        user.setRole(scanner.nextLine().toUpperCase());

        user.setStatus("ACTIVE");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        if (userService.addUser(user)) {
            System.out.println("\nUser Registered Successfully.");
        } else {
            System.out.println("\nRegistration Failed.");
        }
    }

    // ==========================
    // VIEW ALL USERS
    // ==========================
    private void viewAllUsers() {

        List<User> users = userService.getAllUsers();

        System.out.println("\n========== ALL USERS ==========");

        if (users.isEmpty()) {
            System.out.println("No Users Found.");
            return;
        }

        for (User user : users) {

            System.out.println("------------------------------------------");
            System.out.println("User ID    : " + user.getUserId());
            System.out.println("Name       : " + user.getFullName());
            System.out.println("Email      : " + user.getEmail());
            System.out.println("Phone      : " + user.getPhone());
            System.out.println("Role       : " + user.getRole());
            System.out.println("Status     : " + user.getStatus());
            System.out.println("Created At : " + user.getCreatedAt());
        }

        System.out.println("------------------------------------------");
    }

    // ==========================
    // SEARCH USER
    // ==========================
    private void searchUser() {

        System.out.print("\nEnter User ID : ");

        int id = scanner.nextInt();

        User user = userService.getUserById(id);

        if (user == null) {
            System.out.println("\nUser Not Found.");
            return;
        }

        System.out.println("\n========== USER DETAILS ==========");

        System.out.println("User ID    : " + user.getUserId());
        System.out.println("Name       : " + user.getFullName());
        System.out.println("Email      : " + user.getEmail());
        System.out.println("Phone      : " + user.getPhone());
        System.out.println("Role       : " + user.getRole());
        System.out.println("Status     : " + user.getStatus());
        System.out.println("Created At : " + user.getCreatedAt());
    }

    // ==========================
    // UPDATE USER
    // ==========================
    private void updateUser() {

        System.out.print("\nEnter User ID to Update : ");

        int id = scanner.nextInt();
        scanner.nextLine();

        User user = userService.getUserById(id);

        if (user == null) {
            System.out.println("\nUser Not Found.");
            return;
        }

        System.out.println("\n========== UPDATE USER ==========");

        System.out.println("Current Name : " + user.getFullName());
        System.out.print("New Name : ");
        user.setFullName(scanner.nextLine());

        System.out.println("Current Email : " + user.getEmail());
        System.out.print("New Email : ");
        user.setEmail(scanner.nextLine());

        System.out.println("Current Password : " + user.getPassword());
        System.out.print("New Password : ");
        user.setPassword(scanner.nextLine());

        System.out.println("Current Phone : " + user.getPhone());
        System.out.print("New Phone : ");
        user.setPhone(scanner.nextLine());

        System.out.println("Current Role : " + user.getRole());
        System.out.print("New Role : ");
        user.setRole(scanner.nextLine().toUpperCase());

        System.out.println("Current Status : " + user.getStatus());
        System.out.print("New Status (ACTIVE/INACTIVE): ");
        user.setStatus(scanner.nextLine().toUpperCase());

        if (userService.updateUser(user)) {
            System.out.println("\nUser Updated Successfully.");
        } else {
            System.out.println("\nUpdate Failed.");
        }
    }

    // ==========================
    // DELETE USER
    // ==========================
    private void deleteUser() {

        System.out.print("\nEnter User ID to Delete : ");

        int id = scanner.nextInt();

        User user = userService.getUserById(id);

        if (user == null) {
            System.out.println("\nUser Not Found.");
            return;
        }

        System.out.println("\n========== USER DETAILS ==========");
        System.out.println("User ID : " + user.getUserId());
        System.out.println("Name    : " + user.getFullName());
        System.out.println("Email   : " + user.getEmail());

        System.out.print("\nAre you sure? (Y/N): ");

        char confirm = scanner.next().toUpperCase().charAt(0);

        if (confirm == 'Y') {

            if (userService.deleteUser(id)) {
                System.out.println("\nUser Deleted Successfully.");
            } else {
                System.out.println("\nDelete Failed.");
            }

        } else {

            System.out.println("\nDelete Cancelled.");
        }
    }
}