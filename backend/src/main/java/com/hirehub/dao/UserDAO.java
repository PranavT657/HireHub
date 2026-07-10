package com.hirehub.dao;

import com.hirehub.config.DBConnection;
import com.hirehub.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DBConnection.getConnection();
    }

    // ==========================
    // INSERT USER
    // ==========================
    public boolean saveUser(User user) {

        String sql = "INSERT INTO users(full_name, email, password, phone, role, status) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());
            ps.setString(6, user.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Saved Successfully.");
                return true;
            }

        } catch (SQLException e) {

            System.out.println("Error Saving User!");
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET ALL USERS
    // ==========================
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // ==========================
    // GET USER BY ID
    // ==========================
    public User getUserById(int userId) {

        String sql = "SELECT * FROM users WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // UPDATE USER
    // ==========================
    public boolean updateUser(User user) {

        String sql = "UPDATE users SET full_name=?, email=?, password=?, phone=?, role=?, status=? WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());
            ps.setString(6, user.getStatus());
            ps.setInt(7, user.getUserId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Updated Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // DELETE USER
    // ==========================
    public boolean deleteUser(int userId) {

        String sql = "DELETE FROM users WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Deleted Successfully.");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // LOGIN USER
    // ==========================
    public User loginUser(String email, String password) {

        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
                user.setCreatedAt(rs.getTimestamp("created_at"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ==========================
    // CHECK USER EXISTS
    // ==========================
    public boolean userExists(int userId) {

        String sql = "SELECT user_id FROM users WHERE user_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}