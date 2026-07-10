package com.hirehub.ui;

import com.hirehub.model.Company;
import com.hirehub.service.CompanyService;

import java.util.List;
import java.util.Scanner;

public class CompanyUI {

    private Scanner scanner = new Scanner(System.in);
    private CompanyService companyService = new CompanyService();

    public void start() {

        while (true) {

            System.out.println("\n========== COMPANY MANAGEMENT ==========");
            System.out.println("1. Register Company");
            System.out.println("2. View All Companies");
            System.out.println("3. Search Company");
            System.out.println("4. Update Company");
            System.out.println("5. Delete Company");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    registerCompany();
                    break;

                case 2:
                    viewAllCompanies();
                    break;

                case 3:
                    searchCompany();
                    break;

                case 4:
                    updateCompany();
                    break;

                case 5:
                    deleteCompany();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    // ==========================
    // REGISTER COMPANY
    // ==========================
    private void registerCompany() {

        scanner.nextLine();

        Company company = new Company();

        System.out.println("\n========== REGISTER COMPANY ==========");

        System.out.print("User ID : ");
        company.setUserId(scanner.nextInt());

        scanner.nextLine();

        System.out.print("Company Name : ");
        company.setCompanyName(scanner.nextLine());

        System.out.print("Industry : ");
        company.setIndustry(scanner.nextLine());

        System.out.print("Website : ");
        company.setWebsite(scanner.nextLine());

        System.out.print("Location : ");
        company.setLocation(scanner.nextLine());

        System.out.print("Description : ");
        company.setDescription(scanner.nextLine());

        if (companyService.addCompany(company)) {
            System.out.println("\nCompany Registered Successfully.");
        } else {
            System.out.println("\nRegistration Failed.");
        }
    }

    // ==========================
    // VIEW ALL COMPANIES
    // ==========================
    private void viewAllCompanies() {

        List<Company> companies = companyService.getAllCompanies();

        if (companies.isEmpty()) {
            System.out.println("\nNo Companies Found.");
            return;
        }

        System.out.println("\n========== COMPANY LIST ==========");

        for (Company company : companies) {

            System.out.println("-------------------------------------");
            System.out.println("Company ID : " + company.getCompanyId());
            System.out.println("User ID    : " + company.getUserId());
            System.out.println("Name       : " + company.getCompanyName());
            System.out.println("Industry   : " + company.getIndustry());
            System.out.println("Website    : " + company.getWebsite());
            System.out.println("Location   : " + company.getLocation());
            System.out.println("Description: " + company.getDescription());
        }

        System.out.println("-------------------------------------");
    }

    // ==========================
    // SEARCH COMPANY
    // ==========================
    private void searchCompany() {

        System.out.print("\nEnter Company ID : ");
        int id = scanner.nextInt();

        Company company = companyService.getCompanyById(id);

        if (company == null) {
            System.out.println("\nCompany Not Found.");
            return;
        }

        System.out.println("\n========== COMPANY DETAILS ==========");
        System.out.println("Company ID : " + company.getCompanyId());
        System.out.println("User ID    : " + company.getUserId());
        System.out.println("Name       : " + company.getCompanyName());
        System.out.println("Industry   : " + company.getIndustry());
        System.out.println("Website    : " + company.getWebsite());
        System.out.println("Location   : " + company.getLocation());
        System.out.println("Description: " + company.getDescription());
    }

    // ==========================
    // UPDATE COMPANY
    // ==========================
    private void updateCompany() {

        System.out.print("\nEnter Company ID : ");
        int id = scanner.nextInt();

        scanner.nextLine();

        Company company = companyService.getCompanyById(id);

        if (company == null) {
            System.out.println("\nCompany Not Found.");
            return;
        }

        System.out.print("Company Name : ");
        company.setCompanyName(scanner.nextLine());

        System.out.print("Industry : ");
        company.setIndustry(scanner.nextLine());

        System.out.print("Website : ");
        company.setWebsite(scanner.nextLine());

        System.out.print("Location : ");
        company.setLocation(scanner.nextLine());

        System.out.print("Description : ");
        company.setDescription(scanner.nextLine());

        if (companyService.updateCompany(company)) {
            System.out.println("\nCompany Updated Successfully.");
        } else {
            System.out.println("\nUpdate Failed.");
        }
    }

    // ==========================
    // DELETE COMPANY
    // ==========================
    private void deleteCompany() {

        System.out.print("\nEnter Company ID : ");
        int id = scanner.nextInt();

        if (companyService.deleteCompany(id)) {
            System.out.println("\nCompany Deleted Successfully.");
        } else {
            System.out.println("\nDelete Failed.");
        }
    }
}