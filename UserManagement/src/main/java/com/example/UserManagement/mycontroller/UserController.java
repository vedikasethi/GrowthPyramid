package com.example.UserManagement.mycontroller;

import com.example.UserManagement.entity.User;
import com.example.UserManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Register a new user
    @PostMapping("/register/{companyId}")
    public ResponseEntity<User> registerUser(@PathVariable Long companyId, @RequestBody User user) {
        User savedUser = userService.registerUser(companyId, user);
        return savedUser != null ? ResponseEntity.ok(savedUser)
                : ResponseEntity.badRequest().build();
    }

    // Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        return isDeleted ? ResponseEntity.ok("User deleted successfully")
                : ResponseEntity.badRequest().body("User not found");
    }

    // Update user details
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.badRequest().build();
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.loginUser(username, password);
        return user != null ? ResponseEntity.ok(user)
                : ResponseEntity.badRequest().body(null);
    }

    // Logout user
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        boolean isLoggedOut = userService.logoutUser();
        return isLoggedOut ? ResponseEntity.ok("User logged out successfully")
                : ResponseEntity.badRequest().body("No user logged in");
    }

    // Get current user
    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        User user = userService.getCurrentUser();
        return user != null ? ResponseEntity.ok(user)
                : ResponseEntity.badRequest().body(null);
    }
}
