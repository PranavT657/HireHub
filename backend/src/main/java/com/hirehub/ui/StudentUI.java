package com.hirehub.ui;

import com.hirehub.model.Student;
import com.hirehub.model.User;
import com.hirehub.service.StudentService;
import com.hirehub.service.UserService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class StudentUI {

    private Scanner scanner = new Scanner(System.in);

    private StudentService studentService = new StudentService();

    private UserService userService = new UserService();

    public void start() {

        while (true) {

            System.out.println("\n========= STUDENT MANAGEMENT =========");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    System.out.println("Search Student Coming Soon...");
                    break;

                case 4:
                    System.out.println("Update Student Coming Soon...");
                    break;

                case 5:
                    System.out.println("Delete Student Coming Soon...");
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

    }

    // ==================================
    // REGISTER STUDENT
    // ==================================

    private void registerStudent() {

        System.out.println("\n========== AVAILABLE USERS ==========");

        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {

            System.out.println("No Users Found.");
            return;
        }

        for (User user : users) {

            System.out.println(user.getUserId()
                    + " | "
                    + user.getFullName()
                    + " | "
                    + user.getRole());
        }

        Student student = new Student();

        System.out.print("\nEnter User ID : ");
        student.setUserId(scanner.nextInt());

        scanner.nextLine();

        if (!userService.userExists(student.getUserId())) {

            System.out.println("\nUser ID Not Found.");
            return;
        }

        System.out.print("SRN : ");
        student.setSrn(scanner.nextLine());

        System.out.print("Branch : ");
        student.setBranch(scanner.nextLine());

        System.out.print("Semester : ");
        student.setSemester(scanner.nextInt());

        System.out.print("CGPA : ");
        student.setCgpa(scanner.nextDouble());

        System.out.print("Passing Year : ");
        student.setPassingYear(scanner.nextInt());

        scanner.nextLine();

        System.out.print("Gender : ");
        student.setGender(scanner.nextLine());

        System.out.print("DOB (yyyy-mm-dd) : ");
        student.setDob(Date.valueOf(scanner.nextLine()));

        if (studentService.addStudent(student)) {

            System.out.println("\nStudent Registered Successfully.");

        } else {

            System.out.println("\nRegistration Failed.");

        }

    }

    // ==================================
    // VIEW ALL STUDENTS
    // ==================================

    private void viewAllStudents() {

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {

            System.out.println("\nNo Students Found.");
            return;
        }

        System.out.println("\n============= STUDENTS =============");

        for (Student s : students) {

            System.out.println("---------------------------------------");

            System.out.println("Student ID : " + s.getStudentId());
            System.out.println("User ID    : " + s.getUserId());
            System.out.println("SRN        : " + s.getSrn());
            System.out.println("Branch     : " + s.getBranch());
            System.out.println("Semester   : " + s.getSemester());
            System.out.println("CGPA       : " + s.getCgpa());
            System.out.println("Passing Yr : " + s.getPassingYear());
            System.out.println("Gender     : " + s.getGender());
            System.out.println("DOB        : " + s.getDob());

        }

        System.out.println("---------------------------------------");

    }

}