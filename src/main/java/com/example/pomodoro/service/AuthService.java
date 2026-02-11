package com.example.pomodoro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pomodoro.entity.Streak;
import com.example.pomodoro.entity.User;
import com.example.pomodoro.repository.StreakRepository;
import com.example.pomodoro.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private StreakRepository streakRepo;

    // register user
    public User register(String name, String email, String password) {

        Optional<User> existingUser = userRepo.findByEmail(email);

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        User savedUser = userRepo.save(user);

        Streak streak = new Streak();
        streak.setUserId(savedUser.getId());
        streak.setCurrentStreak(0);
        streak.setMaxStreak(0);

        streakRepo.save(streak);

        return savedUser;
    }

    // User Login
    public User login(String email, String password) {

        User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Inavlid password");

        }

        return user;
    }

    public boolean emailExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

}
