package com.example.pomodoro.repository;

import com.example.pomodoro.entity.PomodoroSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PomodoroSessionRepository
                extends JpaRepository<PomodoroSession, Long> {

        List<PomodoroSession> findByUserIdAndSessionDate(
                        Long userId, LocalDate sessionDate);
}
