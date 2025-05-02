package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // Create a new Rating
    public Rating createRating(Rating rating) throws SQLException {
        return ratingRepository.saveRating(rating);
    }

    // Get Rating by ID
    public Rating getRatingById(int id) throws SQLException {
        return ratingRepository.getRatingById(id);
    }

    // Get all Ratings
    public List<Rating> getAllRatings() throws SQLException {
        return ratingRepository.getAllRatings();
    }

    // Update Rating
    public Rating updateRating(Rating rating) throws SQLException {
        return ratingRepository.updateRating(rating);
    }

    // Delete Rating
    public boolean deleteRating(int id) throws SQLException {
        return ratingRepository.deleteRating(id);
    }
}



