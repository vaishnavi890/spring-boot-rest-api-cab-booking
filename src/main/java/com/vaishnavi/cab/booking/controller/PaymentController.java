package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public Payment makePayment(@RequestBody Payment payment) throws SQLException {
        return service.makePayment(payment);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable int id) throws SQLException {
        return service.getPaymentById(id);
    }

    @GetMapping
    public List<Payment> getAllPayments() throws SQLException {
        return service.getAllPayments();
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable int id, @RequestBody Payment payment) throws SQLException {
        return service.updatePayment(new Payment(id, payment.rideId(), payment.userId(), payment.amount(), payment.paymentMethod(), payment.status()));
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable int id) throws SQLException {
        return service.deletePayment(id) ? "Payment deleted" : "Payment not found";
    }
}


