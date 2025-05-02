package com.vaishnavi.cab.booking.model;

public record Rating(int ratingId, int rideId, int userId, int driverId, int rating, String review) {
    public void setRatingId(int id) {
    }
}




