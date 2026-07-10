package com.hirehub.ui;

import com.hirehub.model.Job;
import com.hirehub.service.JobService;

import java.util.List;
import java.util.Scanner;

public class JobUI {

    private Scanner scanner = new Scanner(System.in);
    private JobService jobService = new JobService();

    public void start() {

        while (true) {

            System.out.println("\n========== JOB MANAGEMENT ==========");
            System.out.println("1. Post Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Search Job");
            System.out.println("4. Update Job");
            System.out.println("5. Delete Job");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    postJob();
                    break;

                case 2:
                    viewAllJobs();
                    break;

                case 3:
                    searchJob();
                    break;

                case 4:
                    updateJob();
                    break;

                case 5:
                    deleteJob();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    // ==========================
    // POST JOB
    // ==========================
    private void postJob() {

        scanner.nextLine();

        Job job = new Job();

        System.out.println("\n========== POST JOB ==========");

        System.out.print("Company ID : ");
        job.setCompanyId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Job Title : ");
        job.setJobTitle(scanner.nextLine());

        System.out.print("Job Description : ");
        job.setJobDescription(scanner.nextLine());

        System.out.print("Location : ");
        job.setLocation(scanner.nextLine());

        System.out.print("Salary : ");
        job.setSalary(Double.parseDouble(scanner.nextLine()));

        System.out.print("Minimum CGPA : ");
        job.setMinimumCgpa(Double.parseDouble(scanner.nextLine()));

        System.out.print("Required Semester : ");
        job.setRequiredSemester(Integer.parseInt(scanner.nextLine()));

        System.out.print("Job Type (FULL_TIME / INTERNSHIP / PART_TIME) : ");
        job.setJobType(scanner.nextLine().toUpperCase());

        job.setStatus("OPEN");

        if (jobService.addJob(job)) {
            System.out.println("\nJob Posted Successfully.");
        } else {
            System.out.println("\nFailed to Post Job.");
        }
    }

    // ==========================
    // VIEW ALL JOBS
    // ==========================
    private void viewAllJobs() {

        List<Job> jobs = jobService.getAllJobs();

        if (jobs.isEmpty()) {
            System.out.println("\nNo Jobs Found.");
            return;
        }

        System.out.println("\n========== JOB LIST ==========");

        for (Job job : jobs) {

            System.out.println("----------------------------------------");
            System.out.println("Job ID       : " + job.getJobId());
            System.out.println("Company ID   : " + job.getCompanyId());
            System.out.println("Title        : " + job.getJobTitle());
            System.out.println("Location     : " + job.getLocation());
            System.out.println("Salary       : " + job.getSalary());
            System.out.println("Min CGPA     : " + job.getMinimumCgpa());
            System.out.println("Semester     : " + job.getRequiredSemester());
            System.out.println("Type         : " + job.getJobType());
            System.out.println("Status       : " + job.getStatus());
        }

        System.out.println("----------------------------------------");
    }

    // ==========================
    // SEARCH JOB
    // ==========================
    private void searchJob() {

        System.out.print("\nEnter Job ID : ");
        int id = scanner.nextInt();

        Job job = jobService.getJobById(id);

        if (job == null) {
            System.out.println("\nJob Not Found.");
            return;
        }

        System.out.println("\n========== JOB DETAILS ==========");
        System.out.println("Job ID       : " + job.getJobId());
        System.out.println("Company ID   : " + job.getCompanyId());
        System.out.println("Title        : " + job.getJobTitle());
        System.out.println("Description  : " + job.getJobDescription());
        System.out.println("Location     : " + job.getLocation());
        System.out.println("Salary       : " + job.getSalary());
        System.out.println("Min CGPA     : " + job.getMinimumCgpa());
        System.out.println("Semester     : " + job.getRequiredSemester());
        System.out.println("Type         : " + job.getJobType());
        System.out.println("Status       : " + job.getStatus());
    }

    // ==========================
    // UPDATE JOB
    // ==========================
    private void updateJob() {

        System.out.print("\nEnter Job ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Job job = jobService.getJobById(id);

        if (job == null) {
            System.out.println("\nJob Not Found.");
            return;
        }

        System.out.print("New Job Title : ");
        job.setJobTitle(scanner.nextLine());

        System.out.print("New Description : ");
        job.setJobDescription(scanner.nextLine());

        System.out.print("New Location : ");
        job.setLocation(scanner.nextLine());

        System.out.print("New Salary : ");
        job.setSalary(Double.parseDouble(scanner.nextLine()));

        System.out.print("New Minimum CGPA : ");
        job.setMinimumCgpa(Double.parseDouble(scanner.nextLine()));

        System.out.print("New Semester : ");
        job.setRequiredSemester(Integer.parseInt(scanner.nextLine()));

        System.out.print("New Job Type : ");
        job.setJobType(scanner.nextLine().toUpperCase());

        System.out.print("Status (OPEN/CLOSED) : ");
        job.setStatus(scanner.nextLine().toUpperCase());

        if (jobService.updateJob(job)) {
            System.out.println("\nJob Updated Successfully.");
        } else {
            System.out.println("\nUpdate Failed.");
        }
    }

    // ==========================
    // DELETE JOB
    // ==========================
    private void deleteJob() {

        System.out.print("\nEnter Job ID : ");
        int id = scanner.nextInt();

        if (jobService.deleteJob(id)) {
            System.out.println("\nJob Deleted Successfully.");
        } else {
            System.out.println("\nDelete Failed.");
        }
    }
}