package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_system", "root", "your_password");
    }

    public Payment createPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payments (payment_id, ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, payment.paymentId());
            ps.setInt(2, payment.rideId());
            ps.setInt(3, payment.userId());
            ps.setDouble(4, payment.amount());
            ps.setString(5, payment.paymentMethod());
            ps.setString(6, payment.status());
            ps.executeUpdate();
        }
        return payment;
    }

    public Payment getPaymentById(int paymentId) throws SQLException {
        String sql = "SELECT * FROM payments WHERE payment_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, paymentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Payment(
                            rs.getInt("payment_id"),
                            rs.getInt("ride_id"),
                            rs.getInt("user_id"),
                            rs.getDouble("amount"),
                            rs.getString("payment_method"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("status")
                ));
            }
        }
        return list;
    }

    public Payment updatePayment(Payment payment) throws SQLException {
        String sql = "UPDATE payments SET ride_id=?, user_id=?, amount=?, payment_method=?, status=? WHERE payment_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, payment.rideId());
            ps.setInt(2, payment.userId());
            ps.setDouble(3, payment.amount());
            ps.setString(4, payment.paymentMethod());
            ps.setString(5, payment.status());
            ps.setInt(6, payment.paymentId());
            int rows = ps.executeUpdate();
            if (rows > 0) return payment;
        }
        return null;
    }

    public boolean deletePayment(int paymentId) throws SQLException {
        String sql = "DELETE FROM payments WHERE payment_id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, paymentId);
            return ps.executeUpdate() > 0;
        }
    }

    public Payment savePayment(Payment payment) {
        return payment;
    }
}


