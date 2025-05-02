package com.vaishnavi.cab.booking.model;


public record Payment(int paymentId, int rideId, int userId, double amount, String paymentMethod, String status) {
    public void setPaymentId(int id) {
    }
}


