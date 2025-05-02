package com.vaishnavi.cab.booking.model;

public record Driver(int driverId, String name, String email, String phone, String cabDetails) {
    public void setDriverId(int id) {
    }
}


