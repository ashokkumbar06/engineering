package com.Engeering.Service;

import com.Engeering.Entity.User;
import com.Engeering.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
