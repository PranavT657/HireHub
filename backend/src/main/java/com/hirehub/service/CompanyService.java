package com.hirehub.service;

import com.hirehub.dao.CompanyDAO;
import com.hirehub.model.Company;

import java.util.List;

public class CompanyService {

    private CompanyDAO companyDAO;

    public CompanyService() {
        companyDAO = new CompanyDAO();
    }

    // ==========================
    // ADD COMPANY
    // ==========================
    public boolean addCompany(Company company) {
        return companyDAO.saveCompany(company);
    }

    // ==========================
    // GET ALL COMPANIES
    // ==========================
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    // ==========================
    // GET COMPANY BY ID
    // ==========================
    public Company getCompanyById(int companyId) {
        return companyDAO.getCompanyById(companyId);
    }

    // ==========================
    // UPDATE COMPANY
    // ==========================
    public boolean updateCompany(Company company) {
        return companyDAO.updateCompany(company);
    }

    // ==========================
    // DELETE COMPANY
    // ==========================
    public boolean deleteCompany(int companyId) {
        return companyDAO.deleteCompany(companyId);
    }
}