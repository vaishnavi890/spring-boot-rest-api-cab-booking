package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating createRating(@RequestBody Rating rating) throws SQLException {
        return ratingService.createRating(rating);
    }

    @GetMapping("/{id}")
    public Rating getRating(@PathVariable int id) throws SQLException {
        return ratingService.getRatingById(id);
    }

    @GetMapping
    public List<Rating> getAllRatings() throws SQLException {
        return ratingService.getAllRatings();
    }

    @PutMapping("/{id}")
    public String updateRating(@PathVariable int id, @RequestBody Rating rating) throws SQLException {
        rating.setRatingId(id);
        if (rating != null) {
            return "Rating updated successfully!";
        } else {
            return "Rating update failed!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRating(@PathVariable int id) throws SQLException {
        if (ratingService.deleteRating(id)) {
            return "Rating deleted successfully!";
        } else {
            return "Rating deletion failed!";
        }
    }
}



