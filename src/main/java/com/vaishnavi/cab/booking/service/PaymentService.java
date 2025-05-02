package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Create a new Payment
    public Payment createPayment(Payment payment) throws SQLException {
        return paymentRepository.savePayment(payment);
    }

    // Get Payment by ID
    public Payment getPaymentById(int id) throws SQLException {
        return paymentRepository.getPaymentById(id);
    }

    // Get all Payments
    public List<Payment> getAllPayments() throws SQLException {
        return paymentRepository.getAllPayments();
    }

    // Update Payment
    public Payment updatePayment(Payment payment) throws SQLException {
        return paymentRepository.updatePayment(payment);
    }

    // Delete Payment
    public boolean deletePayment(int id) throws SQLException {
        return paymentRepository.deletePayment(id);
    }

    public Payment makePayment(Payment payment) {
        return payment;
    }
}



