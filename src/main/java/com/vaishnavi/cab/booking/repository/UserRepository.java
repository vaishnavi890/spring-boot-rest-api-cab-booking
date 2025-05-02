package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cab_system";
        String username = "root";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }

    public User createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (user_id, name, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, user.userId());
            ps.setString(2, user.name());
            ps.setString(3, user.email());
            ps.setString(4, user.phone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone")
                    );
                }
            }
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone")
                ));
            }
        }
        return users;
    }

    public User updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name=?, email=?, phone=? WHERE user_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.name());
            ps.setString(2, user.email());
            ps.setString(3, user.phone());
            ps.setInt(4, user.userId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    public User saveUser(User user) {
        return user;
    }
}



