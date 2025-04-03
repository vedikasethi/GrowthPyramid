package com.example.UserManagement.service;

import com.example.CompanyManagement.entity.Company;
import com.example.CompanyManagement.repository.CompanyRepository;
import com.example.UserManagement.entity.User;
import com.example.UserManagement.repository.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    // Get the currently logged-in user
    @Getter
    private User currentUser = null; // Stores the currently logged-in user

    // Register a new user
    public User registerUser(Long companyId, User user) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));

        if (companyOptional.isEmpty()) {
            throw new RuntimeException("Company not found with ID: " + companyId);
        }

        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists: " + user.getUsername());
        }

        // Set the company for the user
        user.setCompany(companyOptional.get());

        // Save and return the new user
        return userRepository.save(user);
    }


    // Delete a user by ID
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update user details
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword());
                    user.setRole(userDetails.getRole());
                    return userRepository.save(user);
                }).orElse(null);
    }

    // Authenticate and login a user
    public User loginUser(String username, String password) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            currentUser = user.get();
            return user.get();
        }
        return null;
    }

    // Logout the current user
    public boolean logoutUser() {
        if (currentUser != null) {
            currentUser = null;
            return true;
        }
        return false;
    }

}
