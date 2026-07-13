package com.hirehub.service;

import com.hirehub.dao.ApplicationDAO;
import com.hirehub.model.Application;

import java.util.List;

public class ApplicationService {

    private ApplicationDAO applicationDAO;

    public ApplicationService() {
        applicationDAO = new ApplicationDAO();
    }

    // ==========================
    // APPLY FOR JOB
    // ==========================
    public boolean applyForJob(Application application) {
        return applicationDAO.saveApplication(application);
    }

    // ==========================
    // GET ALL APPLICATIONS
    // ==========================
    public List<Application> getAllApplications() {
        return applicationDAO.getAllApplications();
    }

    // ==========================
    // GET APPLICATION BY ID
    // ==========================
    public Application getApplicationById(int applicationId) {
        return applicationDAO.getApplicationById(applicationId);
    }

    // ==========================
    // UPDATE APPLICATION STATUS
    // ==========================
    public boolean updateApplication(Application application) {
        return applicationDAO.updateApplication(application);
    }

    // ==========================
    // DELETE APPLICATION
    // ==========================
    public boolean deleteApplication(int applicationId) {
        return applicationDAO.deleteApplication(applicationId);
    }
}