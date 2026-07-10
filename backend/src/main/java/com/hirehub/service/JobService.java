package com.hirehub.service;

import com.hirehub.dao.JobDAO;
import com.hirehub.model.Job;

import java.util.List;

public class JobService {

    private JobDAO jobDAO;

    public JobService() {
        jobDAO = new JobDAO();
    }

    // ==========================
    // ADD JOB
    // ==========================
    public boolean addJob(Job job) {
        return jobDAO.saveJob(job);
    }

    // ==========================
    // GET ALL JOBS
    // ==========================
    public List<Job> getAllJobs() {
        return jobDAO.getAllJobs();
    }

    // ==========================
    // GET JOB BY ID
    // ==========================
    public Job getJobById(int jobId) {
        return jobDAO.getJobById(jobId);
    }

    // ==========================
    // UPDATE JOB
    // ==========================
    public boolean updateJob(Job job) {
        return jobDAO.updateJob(job);
    }

    // ==========================
    // DELETE JOB
    // ==========================
    public boolean deleteJob(int jobId) {
        return jobDAO.deleteJob(jobId);
    }

}