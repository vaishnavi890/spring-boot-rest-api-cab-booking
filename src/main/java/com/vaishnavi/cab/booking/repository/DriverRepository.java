package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_system", "root", "your_password");
    }

    public Driver createDriver(Driver driver) throws SQLException {
        String sql = "INSERT INTO drivers (driver_id, name, email, phone, cab_details) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, driver.driverId());
            ps.setString(2, driver.name());
            ps.setString(3, driver.email());
            ps.setString(4, driver.phone());
            ps.setString(5, driver.cabDetails());
            ps.executeUpdate();
        }
        return driver;
    }

    public Driver getDriverById(int driverId) throws SQLException {
        String sql = "SELECT * FROM drivers WHERE driver_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, driverId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Driver(
                            rs.getInt("driver_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("cab_details")
                    );
                }
            }
        }
        return null;
    }

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM drivers";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("cab_details")
                ));
            }
        }
        return list;
    }

    public Driver updateDriver(Driver driver) throws SQLException {
        String sql = "UPDATE drivers SET name=?, email=?, phone=?, cab_details=? WHERE driver_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, driver.name());
            ps.setString(2, driver.email());
            ps.setString(3, driver.phone());
            ps.setString(4, driver.cabDetails());
            ps.setInt(5, driver.driverId());
            int rows = ps.executeUpdate();
            if (rows > 0) return driver;
        }
        return null;
    }

    public boolean deleteDriver(int driverId) throws SQLException {
        String sql = "DELETE FROM drivers WHERE driver_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, driverId);
            return ps.executeUpdate() > 0;
        }
    }

    public Driver saveDriver(Driver driver) {
        return driver;
    }
}




