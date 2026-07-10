package com.hirehub.model;

import java.sql.Timestamp;

public class Application {

    private int applicationId;
    private int studentId;
    private int jobId;
    private Timestamp applicationDate;
    private String status;

    public Application() {
    }

    public Application(int applicationId,
                       int studentId,
                       int jobId,
                       Timestamp applicationDate,
                       String status) {

        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId=" + applicationId +
                ", studentId=" + studentId +
                ", jobId=" + jobId +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                '}';
    }
}