package com.hirehub.service;

import com.hirehub.dao.StudentDAO;
import com.hirehub.model.Student;

import java.util.List;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // ==========================
    // ADD STUDENT
    // ==========================
    public boolean addStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    // ==========================
    // GET ALL STUDENTS
    // ==========================
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // ==========================
    // GET STUDENT BY ID
    // ==========================
    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================
    public boolean updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    // ==========================
    // DELETE STUDENT
    // ==========================
    public boolean deleteStudent(int studentId) {
        return studentDAO.deleteStudent(studentId);
    }

}