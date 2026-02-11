package com.example.pomodoro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pomodoro.entity.PomodoroSession;
import com.example.pomodoro.repository.PomodoroSessionRepository;

@Service
public class DashboardService {

    @Autowired
    private PomodoroSessionRepository sessionRepo;

    // get todays session
    public List<PomodoroSession> getTodaySessions(Long userId) {
        return sessionRepo.findByUserIdAndSessionDate(userId, LocalDate.now());
    }

    // count study session
    public long getTodayStudyCount(Long userId) {
        return getTodaySessions(userId).stream()
                .filter(s -> s.getSessionType().equals("STUDY"))
                .count();
    }

    // count break session
    public long getTodayBreakCount(Long userId) {
        return getTodaySessions(userId).stream()
                .filter(s -> s.getSessionType().equals("BREAK"))
                .count();
    }

    // total study minutes
    public int getTodayStudyMinutes(Long userId) {
        return getTodaySessions(userId).stream()
                .filter(s -> s.getSessionType().equals("STUDY"))
                .mapToInt(PomodoroSession::getMinutes)
                .sum();
    }

}
