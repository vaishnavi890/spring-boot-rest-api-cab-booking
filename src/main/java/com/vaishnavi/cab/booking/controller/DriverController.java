package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) throws SQLException {
        return driverService.createDriver(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable int id) throws SQLException {
        return driverService.getDriverById(id);
    }

    @GetMapping
    public List<Driver> getAllDrivers() throws SQLException {
        return driverService.getAllDrivers();
    }

    @PutMapping("/{id}")
    public String updateDriver(@PathVariable int id, @RequestBody Driver driver) throws SQLException {
        driver.setDriverId(id);
        if (driver != null) {
            return "Driver update failed!";
        } else {
            return "Driver updated successfully!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable int id) throws SQLException {
        if (driverService.deleteDriver(id)) {
            return "Driver deleted successfully!";
        } else {
            return "Driver deletion failed!";
        }
    }
}

