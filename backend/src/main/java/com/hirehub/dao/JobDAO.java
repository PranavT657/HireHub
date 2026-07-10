package com.hirehub.dao;

import com.hirehub.config.DBConnection;
import com.hirehub.model.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    private Connection connection;

    public JobDAO() {
        connection = DBConnection.getConnection();
    }

    // ==========================
    // SAVE JOB
    // ==========================
    public boolean saveJob(Job job) {

        String sql = "INSERT INTO jobs(company_id, job_title, job_description, location, salary, minimum_cgpa, required_semester, job_type, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, job.getCompanyId());
            ps.setString(2, job.getJobTitle());
            ps.setString(3, job.getJobDescription());
            ps.setString(4, job.getLocation());
            ps.setDouble(5, job.getSalary());
            ps.setDouble(6, job.getMinimumCgpa());
            ps.setInt(7, job.getRequiredSemester());
            ps.setString(8, job.getJobType());
            ps.setString(9, job.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET ALL JOBS
    // ==========================
    public List<Job> getAllJobs() {

        List<Job> jobs = new ArrayList<>();

        String sql = "SELECT * FROM jobs";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getDouble("salary"));
                job.setMinimumCgpa(rs.getDouble("minimum_cgpa"));
                job.setRequiredSemester(rs.getInt("required_semester"));
                job.setJobType(rs.getString("job_type"));
                job.setStatus(rs.getString("status"));

                jobs.add(job);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }

    // ==========================
    // GET JOB BY ID
    // ==========================
    public Job getJobById(int jobId) {

        String sql = "SELECT * FROM jobs WHERE job_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, jobId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setLocation(rs.getString("location"));
                job.setSalary(rs.getDouble("salary"));
                job.setMinimumCgpa(rs.getDouble("minimum_cgpa"));
                job.setRequiredSemester(rs.getInt("required_semester"));
                job.setJobType(rs.getString("job_type"));
                job.setStatus(rs.getString("status"));

                return job;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // UPDATE JOB
    // ==========================
    public boolean updateJob(Job job) {

        String sql = "UPDATE jobs SET company_id=?, job_title=?, job_description=?, location=?, salary=?, minimum_cgpa=?, required_semester=?, job_type=?, status=? WHERE job_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, job.getCompanyId());
            ps.setString(2, job.getJobTitle());
            ps.setString(3, job.getJobDescription());
            ps.setString(4, job.getLocation());
            ps.setDouble(5, job.getSalary());
            ps.setDouble(6, job.getMinimumCgpa());
            ps.setInt(7, job.getRequiredSemester());
            ps.setString(8, job.getJobType());
            ps.setString(9, job.getStatus());
            ps.setInt(10, job.getJobId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // DELETE JOB
    // ==========================
    public boolean deleteJob(int jobId) {

        String sql = "DELETE FROM jobs WHERE job_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, jobId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}