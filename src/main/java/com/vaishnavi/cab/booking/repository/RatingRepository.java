package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RatingRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_system", "root", "your_password");
    }

    public Rating createRating(Rating rating) throws SQLException {
        String sql = "INSERT INTO ratings (rating_id, ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rating.ratingId());
            ps.setInt(2, rating.rideId());
            ps.setInt(3, rating.userId());
            ps.setInt(4, rating.driverId());
            ps.setInt(5, rating.rating());
            ps.setString(6, rating.review());
            ps.executeUpdate();
        }
        return rating;
    }

    public Rating getRatingById(int ratingId) throws SQLException {
        String sql = "SELECT * FROM ratings WHERE rating_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ratingId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Rating(
                            rs.getInt("rating_id"),
                            rs.getInt("ride_id"),
                            rs.getInt("user_id"),
                            rs.getInt("driver_id"),
                            rs.getInt("rating"),
                            rs.getString("review")
                    );
                }
            }
        }
        return null;
    }

    public List<Rating> getAllRatings() throws SQLException {
        List<Rating> list = new ArrayList<>();
        String sql = "SELECT * FROM ratings";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                ));
            }
        }
        return list;
    }

    public Rating updateRating(Rating rating) throws SQLException {
        String sql = "UPDATE ratings SET ride_id=?, user_id=?, driver_id=?, rating=?, review=? WHERE rating_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rating.rideId());
            ps.setInt(2, rating.userId());
            ps.setInt(3, rating.driverId());
            ps.setInt(4, rating.rating());
            ps.setString(5, rating.review());
            ps.setInt(6, rating.ratingId());
            int rows = ps.executeUpdate();
            if (rows > 0) return rating;
        }
        return null;
    }

    public boolean deleteRating(int ratingId) throws SQLException {
        String sql = "DELETE FROM ratings WHERE rating_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ratingId);
            return ps.executeUpdate() > 0;
        }
    }

    public Rating saveRating(Rating rating) {
        return rating;
    }
}


