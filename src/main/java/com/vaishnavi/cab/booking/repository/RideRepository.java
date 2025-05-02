package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RideRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_system", "root", "your_password");
    }

    public Ride createRide(Ride ride) throws SQLException {
        String sql = "INSERT INTO rides (ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ride.rideId());
            ps.setInt(2, ride.userId());
            ps.setInt(3, ride.driverId());
            ps.setString(4, ride.pickupLocation());
            ps.setString(5, ride.dropoffLocation());
            ps.setDouble(6, ride.fare());
            ps.setString(7, ride.status());
            ps.executeUpdate();
        }
        return ride;
    }

    public Ride getRideById(int rideId) throws SQLException {
        String sql = "SELECT * FROM rides WHERE ride_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rideId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Ride(
                            rs.getInt("ride_id"),
                            rs.getInt("user_id"),
                            rs.getInt("driver_id"),
                            rs.getString("pickup_location"),
                            rs.getString("dropoff_location"),
                            rs.getDouble("fare"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public List<Ride> getAllRides() throws SQLException {
        List<Ride> list = new ArrayList<>();
        String sql = "SELECT * FROM rides";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Ride(
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup_location"),
                        rs.getString("dropoff_location"),
                        rs.getDouble("fare"),
                        rs.getString("status")
                ));
            }
        }
        return list;
    }

    public Ride updateRide(Ride ride) throws SQLException {
        String sql = "UPDATE rides SET user_id=?, driver_id=?, pickup_location=?, dropoff_location=?, fare=?, status=? WHERE ride_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ride.userId());
            ps.setInt(2, ride.driverId());
            ps.setString(3, ride.pickupLocation());
            ps.setString(4, ride.dropoffLocation());
            ps.setDouble(5, ride.fare());
            ps.setString(6, ride.status());
            ps.setInt(7, ride.rideId());
            int rows = ps.executeUpdate();
            if (rows > 0) return ride;
        }
        return null;
    }

    public boolean deleteRide(int rideId) throws SQLException {
        String sql = "DELETE FROM rides WHERE ride_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rideId);
            return ps.executeUpdate() > 0;
        }
    }

    public Ride saveRide(Ride ride) {
        return ride;
    }
}

