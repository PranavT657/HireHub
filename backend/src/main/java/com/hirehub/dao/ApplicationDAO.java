package com.hirehub.dao;

import com.hirehub.config.DBConnection;
import com.hirehub.model.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    private Connection connection;

    public ApplicationDAO() {
        connection = DBConnection.getConnection();
    }

    // ==========================
    // SAVE APPLICATION
    // ==========================
    public boolean saveApplication(Application application) {

        String sql = "INSERT INTO applications(student_id, job_id, status) VALUES (?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, application.getStudentId());
            ps.setInt(2, application.getJobId());
            ps.setString(3, application.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET ALL APPLICATIONS
    // ==========================
    public List<Application> getAllApplications() {

        List<Application> applications = new ArrayList<>();

        String sql = "SELECT * FROM applications";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Application application = new Application();

                application.setApplicationId(rs.getInt("application_id"));
                application.setStudentId(rs.getInt("student_id"));
                application.setJobId(rs.getInt("job_id"));
                application.setApplicationDate(rs.getTimestamp("application_date"));
                application.setStatus(rs.getString("status"));

                applications.add(application);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return applications;
    }

    // ==========================
    // GET APPLICATION BY ID
    // ==========================
    public Application getApplicationById(int applicationId) {

        String sql = "SELECT * FROM applications WHERE application_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, applicationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Application application = new Application();

                application.setApplicationId(rs.getInt("application_id"));
                application.setStudentId(rs.getInt("student_id"));
                application.setJobId(rs.getInt("job_id"));
                application.setApplicationDate(rs.getTimestamp("application_date"));
                application.setStatus(rs.getString("status"));

                return application;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // UPDATE APPLICATION STATUS
    // ==========================
    public boolean updateApplication(Application application) {

        String sql = "UPDATE applications SET status=? WHERE application_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, application.getStatus());
            ps.setInt(2, application.getApplicationId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // DELETE APPLICATION
    // ==========================
    public boolean deleteApplication(int applicationId) {

        String sql = "DELETE FROM applications WHERE application_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, applicationId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}