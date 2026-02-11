package com.example.pomodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pomodoro.dto.DashboardResponse;
import com.example.pomodoro.entity.PomodoroSession;
import com.example.pomodoro.entity.Streak;
import com.example.pomodoro.repository.StreakRepository;
import com.example.pomodoro.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardServ;

    @Autowired
    private StreakRepository streakRepository;

    @GetMapping("/today")
    public DashboardResponse getTodaySummary(@RequestParam Long userId) {

        List<PomodoroSession> sessions = dashboardServ.getTodaySessions(userId);

        long studyCount = dashboardServ.getTodayStudyCount(userId);
        long breakCount = dashboardServ.getTodayBreakCount(userId);
        int totalStudyMinutes = dashboardServ.getTodayStudyMinutes(userId);

        DashboardResponse response = new DashboardResponse();

        response.setStudySessions(studyCount);
        response.setBreakSessions(breakCount);
        response.setTotalStudyMinutes(totalStudyMinutes);
        response.setSessions(sessions);

        return response;

    }

    @GetMapping("/streak/{userId}")
    public Streak getStreak(@PathVariable Long userId) {
        return streakRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Streak not found"));
    }

}
