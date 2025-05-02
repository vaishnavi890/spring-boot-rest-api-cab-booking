package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Create a new Driver
    public Driver createDriver(Driver driver) throws SQLException {
        return driverRepository.saveDriver(driver);
    }

    // Get Driver by ID
    public Driver getDriverById(int id) throws SQLException {
        return driverRepository.getDriverById(id);
    }

    // Get all Drivers
    public List<Driver> getAllDrivers() throws SQLException {
        return driverRepository.getAllDrivers();
    }

    // Update Driver
    public Driver updateDriver(Driver driver) throws SQLException {
        return driverRepository.updateDriver(driver);

    }

    // Delete Driver
    public boolean deleteDriver(int id) throws SQLException {
        return driverRepository.deleteDriver(id);
    }
}




