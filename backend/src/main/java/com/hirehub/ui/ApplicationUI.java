package com.hirehub.ui;

import com.hirehub.model.Application;
import com.hirehub.service.ApplicationService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

public class ApplicationUI {

    private Scanner scanner = new Scanner(System.in);
    private ApplicationService applicationService = new ApplicationService();

    public void start() {

        while (true) {

            System.out.println("\n========== APPLICATION MANAGEMENT ==========");
            System.out.println("1. Apply for Job");
            System.out.println("2. View All Applications");
            System.out.println("3. Search Application");
            System.out.println("4. Update Application Status");
            System.out.println("5. Delete Application");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    applyForJob();
                    break;

                case 2:
                    viewAllApplications();
                    break;

                case 3:
                    searchApplication();
                    break;

                case 4:
                    updateApplication();
                    break;

                case 5:
                    deleteApplication();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    // ==========================
    // APPLY FOR JOB
    // ==========================
    private void applyForJob() {

        Application application = new Application();

        System.out.println("\n========== APPLY FOR JOB ==========");

        System.out.print("Student ID : ");
        application.setStudentId(scanner.nextInt());

        System.out.print("Job ID : ");
        application.setJobId(scanner.nextInt());

        application.setApplicationDate(new Timestamp(System.currentTimeMillis()));
        application.setStatus("APPLIED");

        if (applicationService.applyForJob(application)) {
            System.out.println("\nApplication Submitted Successfully.");
        } else {
            System.out.println("\nApplication Failed.");
        }
    }

    // ==========================
    // VIEW ALL APPLICATIONS
    // ==========================
    private void viewAllApplications() {

        List<Application> applications = applicationService.getAllApplications();

        if (applications.isEmpty()) {
            System.out.println("\nNo Applications Found.");
            return;
        }

        System.out.println("\n========== APPLICATION LIST ==========");

        for (Application app : applications) {

            System.out.println("--------------------------------------");
            System.out.println("Application ID : " + app.getApplicationId());
            System.out.println("Student ID     : " + app.getStudentId());
            System.out.println("Job ID         : " + app.getJobId());
            System.out.println("Applied On     : " + app.getApplicationDate());
            System.out.println("Status         : " + app.getStatus());
        }

        System.out.println("--------------------------------------");
    }

    // ==========================
    // SEARCH APPLICATION
    // ==========================
    private void searchApplication() {

        System.out.print("\nEnter Application ID : ");

        int id = scanner.nextInt();

        Application app = applicationService.getApplicationById(id);

        if (app == null) {
            System.out.println("\nApplication Not Found.");
            return;
        }

        System.out.println("\n========== APPLICATION DETAILS ==========");
        System.out.println("Application ID : " + app.getApplicationId());
        System.out.println("Student ID     : " + app.getStudentId());
        System.out.println("Job ID         : " + app.getJobId());
        System.out.println("Applied On     : " + app.getApplicationDate());
        System.out.println("Status         : " + app.getStatus());
    }

    // ==========================
    // UPDATE APPLICATION
    // ==========================
    private void updateApplication() {

        System.out.print("\nEnter Application ID : ");

        int id = scanner.nextInt();

        scanner.nextLine();

        Application app = applicationService.getApplicationById(id);

        if (app == null) {
            System.out.println("\nApplication Not Found.");
            return;
        }

        System.out.println("\nCurrent Status : " + app.getStatus());
        System.out.print("New Status (APPLIED/SHORTLISTED/SELECTED/REJECTED): ");

        app.setStatus(scanner.nextLine().toUpperCase());

        if (applicationService.updateApplication(app)) {
            System.out.println("\nApplication Updated Successfully.");
        } else {
            System.out.println("\nUpdate Failed.");
        }
    }

    // ==========================
    // DELETE APPLICATION
    // ==========================
    private void deleteApplication() {

        System.out.print("\nEnter Application ID : ");

        int id = scanner.nextInt();

        if (applicationService.deleteApplication(id)) {
            System.out.println("\nApplication Deleted Successfully.");
        } else {
            System.out.println("\nDelete Failed.");
        }
    }
}