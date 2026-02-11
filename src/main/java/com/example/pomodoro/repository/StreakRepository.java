package com.example.pomodoro.repository;

import com.example.pomodoro.entity.Streak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreakRepository
        extends JpaRepository<Streak, Long> {

    Optional<Streak> findByUserId(Long userId);
}
