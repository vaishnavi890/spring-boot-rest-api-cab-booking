package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create new User
    public User createUser(User user) throws SQLException {
        return userRepository.saveUser(user);
    }

    // Get User by ID
    public User getUserById(int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    // Get all Users
    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }

    // Update User
    public User updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    // Delete User
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }
}


