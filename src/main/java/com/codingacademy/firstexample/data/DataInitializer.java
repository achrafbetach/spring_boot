package com.codingacademy.firstexample.data;

import com.codingacademy.firstexample.model.User;
import com.codingacademy.firstexample.model.UserRole;
import com.codingacademy.firstexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String adminUsername;
    private final String adminPassword;

    @Autowired
    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           @Value("${admin.username}") String adminUsername,
                           @Value("${admin.password}") String adminPassword) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    @Override
    public void run(String... args) {
        // Check if the admin user already exists
        if (userRepository.findByUsername(adminUsername).isEmpty()) {
            // Create a new admin user
            User admin = new User(adminUsername, passwordEncoder.encode(adminPassword), UserRole.ADMIN, true);
            userRepository.save(admin);
        }
    }
}
