package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    // Create a new Ride
    public Ride createRide(Ride ride) throws SQLException {
        return rideRepository.saveRide(ride);
    }

    // Get Ride by ID
    public Ride getRideById(int id) throws SQLException {
        return rideRepository.getRideById(id);
    }

    // Get all Rides
    public List<Ride> getAllRides() throws SQLException {
        return rideRepository.getAllRides();
    }

    // Update Ride
    public Ride updateRide(Ride ride) throws SQLException {
        return rideRepository.updateRide(ride);
    }

    // Delete Ride
    public boolean deleteRide(int id) throws SQLException {
        return rideRepository.deleteRide(id);
    }
}


