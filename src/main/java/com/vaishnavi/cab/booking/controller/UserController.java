package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User createUser(@RequestBody User user) throws SQLException {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) throws SQLException {
        return service.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() throws SQLException {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public Object updateUser(@PathVariable int id, @RequestBody User user) throws SQLException {
        User existing = service.getUserById(id);
        if (existing != null) {
            return service.updateUser(new User(id, user.name(), user.email(), user.phone()));
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) throws SQLException {
        return service.deleteUser(id) ? "User deleted" : "User not found";
    }
}



