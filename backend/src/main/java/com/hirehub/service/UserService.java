package com.hirehub.service;

import com.hirehub.dao.UserDAO;
import com.hirehub.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    // ==========================
    // ADD USER
    // ==========================
    public boolean addUser(User user) {
        return userDAO.saveUser(user);
    }

    // ==========================
    // GET USER BY ID
    // ==========================
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    // ==========================
    // GET ALL USERS
    // ==========================
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // ==========================
    // UPDATE USER
    // ==========================
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    // ==========================
    // DELETE USER
    // ==========================
    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    // ==========================
    // LOGIN USER
    // ==========================
    public User loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }

    // ==========================
    // CHECK USER EXISTS
    // ==========================
    public boolean userExists(int userId) {
        return userDAO.userExists(userId);
    }
}