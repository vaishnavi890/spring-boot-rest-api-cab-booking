package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) throws SQLException {
        return rideService.createRide(ride);
    }

    @GetMapping("/{id}")
    public Ride getRide(@PathVariable int id) throws SQLException {
        return rideService.getRideById(id);
    }

    @GetMapping
    public List<Ride> getAllRides() throws SQLException {
        return rideService.getAllRides();
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable int id, @RequestBody Ride ride) throws SQLException {
        ride.setRideId(id);
        if (ride != null) {
            return "Ride updated successfully!";
        } else {
            return "Ride update failed!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable int id) throws SQLException {
        if (rideService.deleteRide(id)) {
            return "Ride deleted successfully!";
        } else {
            return "Ride deletion failed!";
        }
    }
}

