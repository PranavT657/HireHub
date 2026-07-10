package com.hirehub.dao;

import com.hirehub.config.DBConnection;
import com.hirehub.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection connection;

    public StudentDAO() {
        connection = DBConnection.getConnection();
    }

    // ==========================
    // SAVE STUDENT
    // ==========================
    public boolean saveStudent(Student student) {

        String sql = "INSERT INTO students(user_id, srn, branch, semester, cgpa, passing_year, gender, dob) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getSrn());
            ps.setString(3, student.getBranch());
            ps.setInt(4, student.getSemester());
            ps.setDouble(5, student.getCgpa());
            ps.setInt(6, student.getPassingYear());
            ps.setString(7, student.getGender());
            ps.setDate(8, student.getDob());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Saved Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET ALL STUDENTS
    // ==========================
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setUserId(rs.getInt("user_id"));
                student.setSrn(rs.getString("srn"));
                student.setBranch(rs.getString("branch"));
                student.setSemester(rs.getInt("semester"));
                student.setCgpa(rs.getDouble("cgpa"));
                student.setPassingYear(rs.getInt("passing_year"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getDate("dob"));

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // ==========================
    // GET STUDENT BY ID
    // ==========================
    public Student getStudentById(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setUserId(rs.getInt("user_id"));
                student.setSrn(rs.getString("srn"));
                student.setBranch(rs.getString("branch"));
                student.setSemester(rs.getInt("semester"));
                student.setCgpa(rs.getDouble("cgpa"));
                student.setPassingYear(rs.getInt("passing_year"));
                student.setGender(rs.getString("gender"));
                student.setDob(rs.getDate("dob"));

                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // UPDATE STUDENT
    // ==========================
    public boolean updateStudent(Student student) {

        String sql = "UPDATE students SET user_id=?, srn=?, branch=?, semester=?, cgpa=?, passing_year=?, gender=?, dob=? WHERE student_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getSrn());
            ps.setString(3, student.getBranch());
            ps.setInt(4, student.getSemester());
            ps.setDouble(5, student.getCgpa());
            ps.setInt(6, student.getPassingYear());
            ps.setString(7, student.getGender());
            ps.setDate(8, student.getDob());
            ps.setInt(9, student.getStudentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // DELETE STUDENT
    // ==========================
    public boolean deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}