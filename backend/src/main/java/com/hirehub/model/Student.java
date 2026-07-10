package com.hirehub.model;

import java.sql.Date;

public class Student {

    private int studentId;
    private int userId;
    private String srn;
    private String branch;
    private int semester;
    private double cgpa;
    private int passingYear;
    private String gender;
    private Date dob;

    public Student() {
    }

    public Student(int studentId, int userId, String srn,
                   String branch, int semester,
                   double cgpa, int passingYear,
                   String gender, Date dob) {

        this.studentId = studentId;
        this.userId = userId;
        this.srn = srn;
        this.branch = branch;
        this.semester = semester;
        this.cgpa = cgpa;
        this.passingYear = passingYear;
        this.gender = gender;
        this.dob = dob;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", userId=" + userId +
                ", srn='" + srn + '\'' +
                ", branch='" + branch + '\'' +
                ", semester=" + semester +
                ", cgpa=" + cgpa +
                ", passingYear=" + passingYear +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }
}