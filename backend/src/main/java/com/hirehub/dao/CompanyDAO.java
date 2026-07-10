package com.hirehub.dao;

import com.hirehub.config.DBConnection;
import com.hirehub.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    private Connection connection;

    public CompanyDAO() {
        connection = DBConnection.getConnection();
    }

    // ==========================
    // SAVE COMPANY
    // ==========================
    public boolean saveCompany(Company company) {

        String sql = "INSERT INTO companies(user_id, company_name, industry, website, location, description) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, company.getUserId());
            ps.setString(2, company.getCompanyName());
            ps.setString(3, company.getIndustry());
            ps.setString(4, company.getWebsite());
            ps.setString(5, company.getLocation());
            ps.setString(6, company.getDescription());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET ALL COMPANIES
    // ==========================
    public List<Company> getAllCompanies() {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT * FROM companies";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Company company = new Company();

                company.setCompanyId(rs.getInt("company_id"));
                company.setUserId(rs.getInt("user_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setIndustry(rs.getString("industry"));
                company.setWebsite(rs.getString("website"));
                company.setLocation(rs.getString("location"));
                company.setDescription(rs.getString("description"));

                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;
    }

    // ==========================
    // GET COMPANY BY ID
    // ==========================
    public Company getCompanyById(int companyId) {

        String sql = "SELECT * FROM companies WHERE company_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, companyId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Company company = new Company();

                company.setCompanyId(rs.getInt("company_id"));
                company.setUserId(rs.getInt("user_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setIndustry(rs.getString("industry"));
                company.setWebsite(rs.getString("website"));
                company.setLocation(rs.getString("location"));
                company.setDescription(rs.getString("description"));

                return company;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // UPDATE COMPANY
    // ==========================
    public boolean updateCompany(Company company) {

        String sql = "UPDATE companies SET user_id=?, company_name=?, industry=?, website=?, location=?, description=? WHERE company_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, company.getUserId());
            ps.setString(2, company.getCompanyName());
            ps.setString(3, company.getIndustry());
            ps.setString(4, company.getWebsite());
            ps.setString(5, company.getLocation());
            ps.setString(6, company.getDescription());
            ps.setInt(7, company.getCompanyId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // DELETE COMPANY
    // ==========================
    public boolean deleteCompany(int companyId) {

        String sql = "DELETE FROM companies WHERE company_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, companyId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}