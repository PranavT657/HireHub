package com.hirehub.model;

public class Job {

    private int jobId;
    private int companyId;
    private String jobTitle;
    private String jobDescription;
    private String location;
    private double salary;
    private double minimumCgpa;
    private int requiredSemester;
    private String jobType;
    private String status;

    public Job() {
    }

    public Job(int jobId, int companyId, String jobTitle,
               String jobDescription, String location,
               double salary, double minimumCgpa,
               int requiredSemester, String jobType,
               String status) {

        this.jobId = jobId;
        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.location = location;
        this.salary = salary;
        this.minimumCgpa = minimumCgpa;
        this.requiredSemester = requiredSemester;
        this.jobType = jobType;
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public int getRequiredSemester() {
        return requiredSemester;
    }

    public void setRequiredSemester(int requiredSemester) {
        this.requiredSemester = requiredSemester;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}