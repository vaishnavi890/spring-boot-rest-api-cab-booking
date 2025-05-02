package com.vaishnavi.cab.booking.model;

public record User (int userId, String name, String email, String phone) {
    public void setUserId(int id) {
    }
}

