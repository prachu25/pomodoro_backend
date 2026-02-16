package com.example.pomodoro.service;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pomodoro.entity.PomodoroSession;
import com.example.pomodoro.entity.Streak;
import com.example.pomodoro.repository.PomodoroSessionRepository;
import com.example.pomodoro.repository.StreakRepository;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroSessionRepository sessionRepo;

    @Autowired
    private StreakRepository streakRepo;

    // start study Session
    public void startStudy(Long userId, int minutes) {

        PomodoroSession session = new PomodoroSession();
        session.setUserId(userId);
        session.setSessionType("STUDY");
        session.setMinutes(minutes);
        session.setSessionDate(LocalDate.now());

        sessionRepo.save(session);

        updateStreak(userId); // After study the streak will upadte

    }

    // start Break Session
    public void startBreak(Long userId, int minutes) {

        PomodoroSession session = new PomodoroSession();
        session.setUserId(userId);
        session.setSessionType("BREAK");
        session.setMinutes(minutes);
        session.setSessionDate(LocalDate.now());

        sessionRepo.save(session);
    }

    // streak update logic
    private void updateStreak(Long userId) {

        Streak streak = streakRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Streak not found"));

        LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        LocalDate lastDate = streak.getLastStudyDate();

        if (lastDate == null) {
            streak.setCurrentStreak(1);
        } else if (lastDate.isEqual(today)) {
            return; // already counted today
        } else if (lastDate.plusDays(1).isEqual(today)) {
            streak.setCurrentStreak(streak.getCurrentStreak() + 1);
        } else {
            streak.setCurrentStreak(1); // streak broken
        }

        streak.setLastStudyDate(today);

        if (streak.getCurrentStreak() > streak.getMaxStreak()) {
            streak.setMaxStreak(streak.getCurrentStreak());
        }

        streakRepo.save(streak);
    }

}
